package com.study.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GetMsgFromProducer {
    @RabbitListener(queues = {"spring.boot.queue"})
    public void handlerHelloMsg(Message message, Channel channel){
        System.out.println(message);
        System.out.println(channel);
    }
}
