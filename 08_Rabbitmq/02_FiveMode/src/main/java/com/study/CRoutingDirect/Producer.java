package com.study.CRoutingDirect;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.utils.RabbitUtils;

import java.io.IOException;

/*
    直连模式，分配指定的key来让路由分发到不同的queue下
 */
public class Producer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 声明一个直连交换机
        channel.exchangeDeclare("directex", BuiltinExchangeType.DIRECT);
        channel.basicPublish("directex","vip1",null,"这是vip1才能看到的内容".getBytes());
        channel.basicPublish("directex","vip2",null,"这是vip2才能看到的内容".getBytes());
        channel.basicPublish("directex","vip3",null,"这是vip3才能看到的内容".getBytes());
        RabbitUtils.close(connection,channel);
    }
}
