package com.study.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyWatchMQConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
        在这个构造器在构造结束的时候立马给RabbitTemplate赋值
        在程序执行的时候，会加载这个配置类，必须等这个配置类加载完成，而下面的配置又对RabbitTemplate进行了增强
        并且线程绝对安全
     */
    @PostConstruct
    public void postProcessRabbitTemplate() {
        // 这里需要传入接口的实现类，而下面就是接口的实现类
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }


    // 进入路由器时的回调
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String course) {
        System.out.println(correlationData);
        System.out.println(ack ? "进路由器来了" : "没进路由器");
        System.out.println(course);
    }
    // 没有进入队列时的回调
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.println(new String(returnedMessage.getMessage().getBody()));
        // 去到出现问题后设置的id值来记录queue内容丢失的情况
        System.out.println(returnedMessage.getMessage().getMessageProperties().getAppId());
        System.out.println(returnedMessage.getExchange());
        System.out.println(returnedMessage.getRoutingKey());
        System.out.println(returnedMessage.getReplyCode());
        System.out.println(returnedMessage.getReplyText());
    }
}
