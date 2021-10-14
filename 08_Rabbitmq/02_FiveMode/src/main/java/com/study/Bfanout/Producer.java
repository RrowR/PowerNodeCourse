package com.study.Bfanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Producer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 设置路由器模式为广播模式
        channel.exchangeDeclare("fanoutex", BuiltinExchangeType.FANOUT);
        for (int i = 1;i <= 10;i++) {
            channel.basicPublish("fanoutex","",null,("这是我的广播模式msg "+i).getBytes());
        }

        RabbitUtils.close(connection,channel);

    }
}
