package com.study.demo;

import com.rabbitmq.client.*;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work_queue",true,false,false,null);
        channel.basicConsume("work_queue",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("我是第二个队列我消费了"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
        System.in.read();
        RabbitUtils.close(connection,channel);
    }
}
