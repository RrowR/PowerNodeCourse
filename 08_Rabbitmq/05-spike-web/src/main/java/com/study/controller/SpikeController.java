package com.study.controller;

import cn.hutool.bloomfilter.BloomFilter;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SpikeController {

    @Autowired
    private BloomFilter bloomFilter;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 接受秒杀请求
     * 一个用户对一个商品 只能抢购一次
     * 1.针对用户和商品进行去重
     * 2.扣减redis的商品库存
     * 3.组装数据放入mq
     */
    @GetMapping("dospike")
    public String doSpike(Integer userId, Integer goodsId) {
        // 拼接一个唯一标识
        String spikeId = userId + "-" + goodsId;
        // 判断是否在bloom过滤器中存在,如果存在就自己返回
        if (bloomFilter.contains(spikeId)) {
            return "您已经参与商品的抢购";
        }
        // 如果走到这一行，说明这个用户没有买过，那么直接扣减商品库存
        Long stock = redisTemplate.opsForValue().decrement("goods_stock:" + goodsId);
        if (stock < 0) {
            return "商品已经被抢完了,请下次再来哦";
        }
        // 如果走到了这行，可以进行抢购，发送到mq中去,让另一个监听mq的模块去慢慢消费
        bloomFilter.add(spikeId);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        String jsonStr = JSON.toJSONString(map);
        rabbitTemplate.convertAndSend("spike.ex","direct", jsonStr);
        return "商品正在抢购中，请稍后查看...";
    }

}
