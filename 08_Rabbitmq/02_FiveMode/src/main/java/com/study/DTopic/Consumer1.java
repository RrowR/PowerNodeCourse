package com.study.DTopic;

import com.rabbitmq.client.*;
import com.study.utils.RabbitUtils;

import java.io.IOException;

/*
    * (star) can substitute for exactly one word.    匹配不多不少恰好1个词
    # (hash) can substitute for zero or more words.  匹配0个或多个词
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"topicex","user.*");
        channel.basicConsume(queue,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("我是消费者1，可以消费 "+new String(body));
            }
        });
        System.in.read();
        RabbitUtils.close(connection,channel);
    }
}
