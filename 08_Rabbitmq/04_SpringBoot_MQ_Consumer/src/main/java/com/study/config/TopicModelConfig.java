package com.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicModelConfig {
    @Bean
    public Queue toPicQueue1(){
        return new Queue("topic.Q1");
    }

    @Bean
    public Queue toPicQueue2(){
        return new Queue("topic.Q2");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("toPicEx");
    }

    @Bean
    public Binding binding01(){
        return BindingBuilder.bind(toPicQueue1()).to(topicExchange()).with("com.#");
    }

    @Bean
    public Binding binding02(){
        return BindingBuilder.bind(toPicQueue2()).to(topicExchange()).with("com.*");
    }
}
