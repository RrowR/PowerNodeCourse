package com.study.listner;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.study.model.RentHouse;
import com.study.service.HousesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class RabbitListner {

    @Autowired
    private HousesService housesService;

    /**
     * 开始消费
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "rent.house.queue")
    public void listenerMsg(Message message, Channel channel){
        log.info("我消息进来了");
        RentHouse rentHouse = JSON.parseObject(new String(message.getBody()), RentHouse.class);
        System.out.println(rentHouse);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
