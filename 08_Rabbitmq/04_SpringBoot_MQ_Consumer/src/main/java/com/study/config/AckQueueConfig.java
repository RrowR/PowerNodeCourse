package com.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AckQueueConfig {
    @Bean
    public Queue ackqueue01(){
        return new Queue("ack.queue.01");
    }

    @Bean
    public Queue ackqueue02(){
        return new Queue("ack.queue.02");
    }

    @Bean
    public Queue ackqueue03(){
        return new Queue("ack.queue.03");
    }

    @Bean
    public Queue ackqueue04(){
        return new Queue("ack.queue.04");
    }

    @Bean
    public DirectExchange ackRoute(){
        return new DirectExchange("ackRoute");
    }

    @Bean
    public Binding bind01(){
        return BindingBuilder.bind(ackqueue01()).to(ackRoute()).with("vip1");
    }

    @Bean
    public Binding bind02(){
        return BindingBuilder.bind(ackqueue02()).to(ackRoute()).with("vip2");
    }

    @Bean
    public Binding bind03(){
        return BindingBuilder.bind(ackqueue03()).to(ackRoute()).with("vip3");
    }

    @Bean
    public Binding bind04(){
        return BindingBuilder.bind(ackqueue04()).to(ackRoute()).with("vip4");
    }
}
