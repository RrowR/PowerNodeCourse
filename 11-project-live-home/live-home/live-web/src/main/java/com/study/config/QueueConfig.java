package com.study.config;

import com.study.enums.QueueEnums;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue queue(){
        return new Queue(QueueEnums.RENT_HOUSE_QUEUE.getQueueName());
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(QueueEnums.RENT_HOUSE_EX.getQueueName());
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(QueueEnums.RENT_HOUSE_KEY.getQueueName());
    }



}
