package com.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    路由直连模式，在广播的前提下，指定不同的queue来接收
 */
@Configuration
public class RoutingDirect {
    @Bean
    public Queue directQ1(){
        return new Queue("com.direct.Q1");
    }

    @Bean
    public Queue directQ2(){
        return new Queue("com.direct.Q2");
    }

    /*
        创建路由直连交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("DirectEx");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(directQ1()).to(directExchange()).with("vip1");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(directQ2()).to(directExchange()).with("vip1");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(directQ2()).to(directExchange()).with("vip2");
    }

}
