package com.study.listener;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.study.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SpikeListener {

    @Autowired
    private OrderService orderService;


    /**
     * 监听消息，开始消费
     *
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "spike.queue", concurrency = "3-5")
    public void handlerSpike(Message message, Channel channel) {
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        Integer userId = jsonObject.getInteger("userId");
        Integer goodsId = jsonObject.getInteger("goodsId");
        try {
            orderService.doSpike(userId, goodsId);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("抢购失败，用户id为{}，商品id为{}", userId, goodsId);
        }
    }

}
