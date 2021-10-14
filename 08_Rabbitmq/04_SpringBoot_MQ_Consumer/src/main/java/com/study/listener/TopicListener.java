package com.study.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;
import java.util.Arrays;

@Component
public class TopicListener {
//    @RabbitListener(queues = "topic.Q1")
//    public void getTopic01(String data){
//        System.out.println("我是消费者1监听"+data);
//    }
//
//    @RabbitListener(queues = "topic.Q2")
//    public void getTopic02(String data){
//        System.out.println("我是消费者2监听"+data);
//    }

    @RabbitListener(queues = "topic.Q1")
    public void getTopic01(Message msg){
        System.out.println("我是消费者1监听"+ new String(msg.getBody()));
    }

    @RabbitListener(queues = "topic.Q2")
    public void getTopic02(Message msg){
        System.out.println("我是消费者2监听"+ new String(msg.getBody()));
    }
}
