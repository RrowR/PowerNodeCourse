package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/*
    测试手动提交以及设置重连次数
 */
@SpringBootTest
class TestAck {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void TestAckMsg(){
        rabbitTemplate.convertAndSend("ackRoute","vip1","这是一个ackRoute交换机发过来给vip1需要签收的信息");
        rabbitTemplate.convertAndSend("ackRoute","vip2","这是一个ackRoute交换机发过来的vip2需要签收的信息");
        rabbitTemplate.convertAndSend("ackRoute","vip3","这是一个ackRoute交换机发过来的vip3需要签收的信息",message -> {
            // 实现了 MessagePostProcessor 接口 里的 Message postProcessMessage(Message message); 抽象方法
            MessageProperties messageProperties = message.getMessageProperties();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            messageProperties.setMessageId(uuid);
            return message;
        });
    }

}
