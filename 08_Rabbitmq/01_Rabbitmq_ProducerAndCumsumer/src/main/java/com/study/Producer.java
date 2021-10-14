package com.study;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 使用连接工厂设置并创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.72.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();

        // 拿到连接后创建信道
        Channel channel = connection.createChannel();
        // 使用信道来声明一个队列
        channel.queueDeclare("hello",true,false,false,null);
        // 发布消息
        channel.basicPublish("","hello",null,"this is my mq msg".getBytes());
        channel.close();
        connection.close();
        System.out.println("消息已发送");
    }
}
