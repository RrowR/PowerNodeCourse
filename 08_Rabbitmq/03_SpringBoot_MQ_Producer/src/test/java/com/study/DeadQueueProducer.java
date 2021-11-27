package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class DeadQueueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 生产者向延迟队列里发送消息
     */
    @Test
    public void testDelayMsg() {
        // 向延迟队列里发消息
        rabbitTemplate.convertAndSend("ms.dead.queue", "我是一个延迟消息");
        System.out.println("发送时间:" + LocalDateTime.now());
    }

    @Test
    public void testCustomDelayMsg(){
        // 发送指定延迟时间的msg
        rabbitTemplate.convertAndSend("ms.dead.queue","我是一个被指定了5秒生存时间的消息",message -> {
            message.getMessageProperties().setExpiration("5000");       // 设置 5 秒
            return message;
        });
    }

}
