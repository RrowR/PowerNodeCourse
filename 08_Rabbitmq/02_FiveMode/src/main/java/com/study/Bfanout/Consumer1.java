package com.study.Bfanout;

import com.rabbitmq.client.*;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 声明一个广播交换机
        channel.exchangeDeclare("fanoutex", BuiltinExchangeType.FANOUT);
        // 从channel里获得一个临时队列，用来和交换机绑定，生产者那里并没有定义
        String queue = channel.queueDeclare().getQueue();
        // 队列和交换机绑定
        channel.queueBind(queue,"fanoutex","");
        // 消费
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("我是消费者1，我正在消费"+new String(body));
            }
        });
        System.in.read();
        RabbitUtils.close(connection,channel);
    }
}
