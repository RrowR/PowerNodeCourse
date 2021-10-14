package com.study.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanOutModel {


    @RabbitListener(queuesToDeclare = {@Queue("fan.out.01")})
    public void FanOutModelReceive(String data){
        System.out.println("我是消费者1，监听" + data);
    }

    @RabbitListener(queuesToDeclare = {@Queue("fan.out.02")})
    public void FanOutModelReceive2(String data){
        System.out.println("我是消费者2，监听" + data);
    }

    @RabbitListener(queuesToDeclare = {@Queue("fan.out.03")})
    public void FanOutModelReceive3(String data){
        System.out.println("我是消费者3，监听" + data);
    }


}
