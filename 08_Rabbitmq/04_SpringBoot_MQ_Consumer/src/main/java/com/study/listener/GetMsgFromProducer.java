package com.study.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = {"spring.boot.queue"})
public class GetMsgFromProducer {
//    @RabbitListener(queues = {"spring.boot.queue"})
//    public void handlerHelloMsg(Message message, Channel channel){
//        System.out.println("我是第一个消费者"+message);
////        System.out.println(channel);
//    }
//
//    @RabbitListener(queues = {"spring.boot.queue"})
//    public void handlerHelloMsg2(Message message, Channel channel,String data){
////        System.out.println("我是第二个消费者"+message);
//        System.out.println("我是第二个消费者"+data);
//    }

    @RabbitListener(queuesToDeclare = {@Queue("spring.boot.queue")})
    public void handlerHelloMsg4(Message message, Channel channel,String data){
//        System.out.println("我是第二个消费者"+message);
        System.out.println("我是第二个消费者"+data);
    }

    // 使用 @RabbitHandler 时，参数类型必须是String类型
//    @RabbitHandler
//    public void handlerHelloMsg3(String msg){
//        System.out.println(msg);
//    }
}
