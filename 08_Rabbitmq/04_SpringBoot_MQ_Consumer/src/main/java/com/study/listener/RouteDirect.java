package com.study.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteDirect {
    @RabbitListener(queues = "com.direct.Q1")
    public void getData01(String data){
        System.out.println("我是消费者1 监听到了vip1的数据" + data);
    }

    @RabbitListener(queues = "com.direct.Q2")
    public void getData02(String data){
        System.out.println("我是消费者2 监听到了vip2的数据" + data);
    }
}
