package com.study.DTopic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Producer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 创建topic(只能模式)交换机
        channel.exchangeDeclare("topicex",BuiltinExchangeType.TOPIC);
        channel.basicPublish("topicex","user",null,"我是user的信息".getBytes());
        channel.basicPublish("topicex","user.menu",null,"我是user.menu的信息".getBytes());
        channel.basicPublish("topicex","user.menu.info",null,"我是user.menu.info的信息".getBytes());
        channel.basicPublish("topicex","user.kora.info",null,"我是user.kora.info的信息".getBytes());
        RabbitUtils.close(connection,channel);
    }
}
