package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;

@SpringBootTest
public class ManuRetryCode {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 给message设置一个唯一的MessageID
    @Test
    void AutoDetectiveAndRetry04(){
        rabbitTemplate.convertAndSend("ackRoute","vip4","这是ackRoute发给vip4的报文",message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            messageProperties.setMessageId(UUID.randomUUID().toString().replaceAll("-",""));
            return message;
        });
    }
}
