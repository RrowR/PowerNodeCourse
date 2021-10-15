package com.study.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class AckQueueListener {
    @RabbitListener(queues = "ack.queue.01")
    public void manualAckConsumer01(Message message, Channel channel) {
        // 这里只打印不签收(前提是开启了自动接收)
        System.out.println("我是消费者1，我消费了" + new String(message.getBody()));
        System.out.println(channel);
        System.out.println(message.getMessageProperties().getDeliveryTag());
    }

    @RabbitListener(queues = "ack.queue.02")
    public void manualAckConsumer02(Message message, Channel channel) {
        // 接收
        System.out.println("我是消费者2，我消费了" + new String(message.getBody()));
        // 每次接收都可以在message里获得一个投递id，这个投递id会一直往上累加，且不能作为唯一标识
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("deliveryTag = " + deliveryTag);
        try {
            // 根据这个投递id来进行接收，multiple: flase 不签收比投递id小的消息
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(channel);
    }

    @RabbitListener(queues = "ack.queue.03")
    public void manualAckConsumer03(Message message, Channel channel) {
        System.out.println("我是消费者3消费了" + new String(message.getBody()));
        // 这里就可以获得增强message里得到的唯一消息ID值(UUID值)
        String messageId = message.getMessageProperties().getMessageId();
        System.out.println(messageId);
        // 获得签收的标识
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
        /*
            basicNack里拒绝签收的参数意义:
            deliveryTag – the tag from the received AMQP.Basic.GetOk or AMQP.Basic.Deliver
            multiple – true to reject all messages up to and including the supplied delivery tag; false to reject just the supplied delivery tag.
            requeue – true if the rejected message(s) should be requeued rather than discarded/dead-lettered
         */
            // 注意:这里如果拒绝签收，会让别的queue来处理，但是我这里只有1个queue来签收queue3，所以会一直重复循环拒绝
            channel.basicNack(deliveryTag, false, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /*
//        手动编写一个重试机制的代码
//     */
//    @RabbitListener(queues = "ack.queue.04")
//    public void RetryAckCode04(Message message, Channel channel) {
//        System.out.println("我是消费者4，看到了" + new String(message.getBody()));
//        System.out.println("唯一报文id=" + message.getMessageProperties().getMessageId());
//        try {
//            toSaveUser();
//            // 成功了就签收
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (Exception e) {
//            int a = 0;
//            while (a < 3) {
//                try {
//                    Thread.sleep(100);  // 睡眠100ms后重试一次
//                    toSaveUser();     // 保存成功
//                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);           // 签收
//                    return;     // 直接结束循环
//                } catch (Exception exception) {
//                    a++;            // 失败则继续尝试保存
//                }
//            }
//        }
//        // 如果3次都失败了则 手动签收 , 避免mq循环接收 , 并交给人工处理
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 方式2 ,使用redis来记录
    @RabbitListener(queues = "ack.queue.04")
    public void RetryAckCode05(Message message, Channel channel) {
        System.out.println("我是消费者4，看到了" + new String(message.getBody()));
        System.out.println("唯一报文id=" + message.getMessageProperties().getMessageId());
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println(deliveryTag);
        try {
            toSaveUser();
            // 成功了就签收
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            String messageId = message.getMessageProperties().getMessageId();
            // 把这个唯一id传到redis里面去,这里不需要设置值再进行赋值的操作
            Long increment = redisTemplate.opsForValue().increment(messageId);
            if (increment < 3L){
                try {
                    // 让他重回队列
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
                    // 结束方法，这里程序是不会继续往下运行了的
                    return;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            try {
                // 如果所有的其他队列加起来已经操作3次了，那么我们直接签收
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }



    }

    private void toSaveUser() {
        int a = 10 / 0;
    }
}
