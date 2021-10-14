package com.study.CRoutingDirect;

import com.rabbitmq.client.*;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"directex","vip2");
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("我是vip2，我可以消费 "+new String(body));
            }
        });
        System.in.read();
        RabbitUtils.close(connection,channel);
    }
}
