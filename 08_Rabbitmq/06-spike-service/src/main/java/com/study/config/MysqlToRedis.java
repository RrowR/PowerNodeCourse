package com.study.config;

import com.study.domain.Goods;
import com.study.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class MysqlToRedis implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private GoodsService goodsService;


    /**
     * 1.查询数据库
     * 2.写入redis
     */
    public void initGoods2Redis() {
        List<Goods> goodsList = goodsService.list();
        if (CollectionUtils.isEmpty(goodsList)) {
            // 如果查询为空那么直接结束就好了
            return;
        }
        // 遍历每一个商品到redis中
        goodsList.forEach(goods -> {
            stringRedisTemplate.opsForValue().set("goods_stock:" + goods.getGoodsId(), goods.getTotalStocks().toString());
        });
    }

    /**
     * 实现 CommandLineRunner 方法，在程序运行时就执行里面的方法
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        initGoods2Redis();
    }
}
