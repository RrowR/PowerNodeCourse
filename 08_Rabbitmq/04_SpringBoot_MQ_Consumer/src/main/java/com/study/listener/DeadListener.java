package com.study.listener;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class DeadListener {

    // 监听延迟队列发到死信队列的消息
    @RabbitListener(queues = "deadQueue")
    public void listeningMsg(Message message, Channel channel){
        System.out.println(LocalDateTime.now());
        System.out.println(new String(message.getBody()));
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
