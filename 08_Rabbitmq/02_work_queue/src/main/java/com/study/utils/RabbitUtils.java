package com.study.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitUtils {
    public static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.72.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setConnectionTimeout(5000);
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            // 1.工厂创建连接
            connection = connectionFactory.newConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Channel channel){
        try {
            if (channel != null) channel.close();
            if (connection != null) connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
