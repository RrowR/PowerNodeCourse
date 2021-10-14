package com.study;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 使用连接工厂设置并创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.72.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        // 使用channer来进行消费
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(envelope);
                System.out.println(properties);
                System.out.println(new String(body));
            }
        });
        // 挂起jvm
//        System.in.read();
        Thread.currentThread().join();

        channel.close();
        connection.close();
    }
}
