package com.study.service.impl;

import com.study.domain.Goods;
import com.study.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Order;
import com.study.mapper.OrderMapper;
import com.study.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Long time = 1000L;

    /**
     * 1.减库存
     * 2.写订单表
     * 这里会有多线程问题
     *
     * @param userId
     * @param goodsId
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void doSpike(Integer userId, Integer goodsId) {
        Long localTime = 0L;
        while (localTime < time) {
            // 在redis里设置一个字段来设置分布式锁
            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent("spike_ifAbsent" + goodsId, "", Duration.ofSeconds(30));
            if (flag) {
                try {
                    // 查询商品
                    Goods goods = goodsMapper.selectById(goodsId);
                    // 扣减库存
                    Integer finalCount = goods.getTotalStocks() - 1;
                    // 如果库存不足，就抛出异常
                    if (finalCount < 0) {
                        throw new IllegalArgumentException("商品" + goods + "库存不足");
                    }
                    goods.setTotalStocks(finalCount);
                    goods.setUpdateTime(new Date());
                    int i = goodsMapper.updateById(goods);
                    // 如果更新成功
                    if (i > 0) {
                        writeOrder(userId, goodsId);
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } finally {
                    // 这里使用try/catch里的finally来释放redis锁
                    stringRedisTemplate.delete("spike_ifAbsent" + goodsId);
                }
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                localTime += 200L;
            }
        }


    }

    /**
     * 写订单表
     *
     * @param userId
     * @param goodsId
     */
    private void writeOrder(Integer userId, Integer goodsId) {
        Order order = new Order();
        order.setCreatetime(new Date());
        order.setGoodsid(goodsId);
        order.setUserid(userId);
        orderMapper.insert(order);
    }
}
