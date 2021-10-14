package com.study.Aworkqueue;

import com.rabbitmq.client.*;
import com.study.utils.RabbitUtils;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 使用信道来定义一个队列
        // 4.声明队列
        // 第一个参数：队列名称
        // 第二个参数：是否持久化这个队列
        // 第三个参数：该通道是否独占这个队列
        // 第四个参数：当队列中没有消息以后 是否删除这个队列
        // 第五个参数：这个队列的其他设置（延迟队列时使用）
        channel.queueDeclare("work_queue",true,false,false,null);
        channel.basicConsume("work_queue",false,new DefaultConsumer(channel){
            int i = 0;
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                i++;
                if (i > 2){
                    int a = 10 / 0;
                }
                System.out.println("我是第一个消费者消费了"+new String(body));
                // 手动签收
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
        System.in.read();
        RabbitUtils.close(connection,channel);
    }
}
