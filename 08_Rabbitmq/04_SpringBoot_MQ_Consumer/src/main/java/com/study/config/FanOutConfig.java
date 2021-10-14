package com.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanOutConfig {

    @Bean
    public Queue fanout01(){
        return new Queue("fan.out.01");
    }

    @Bean
    public Queue fanout02(){
        return new Queue("fan.out.02");
    }

    @Bean
    public Queue fanout03(){
        return new Queue("fan.out.03");
    }

    /* 创建路由 */
    @Bean
    public FanoutExchange fanoutEx(){
        return new FanoutExchange("fanoutEx.boot");
    }

    /*
        给每个路由绑定queue
     */
    @Bean
    public Binding fanOutBindQueueBind01(){
        return BindingBuilder.bind(fanout01()).to(fanoutEx());
    }

    @Bean
    public Binding fanOutBindQueueBind02(){
        return BindingBuilder.bind(fanout02()).to(fanoutEx());
    }

    @Bean
    public Binding fanOutBindQueueBind03(){
        return BindingBuilder.bind(fanout03()).to(fanoutEx());
    }
}
