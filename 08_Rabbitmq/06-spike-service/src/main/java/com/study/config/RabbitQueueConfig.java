package com.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitQueueConfig {

    @Bean
    public Queue spikeQueue() {
        return new Queue("spike.queue");
    }

    @Bean
    public DirectExchange spikeEx() {
        return new DirectExchange("spike.ex");
    }

    @Bean
    public Binding bindSpike() {
        return BindingBuilder.bind(spikeQueue()).to(spikeEx()).with("direct");
    }

}
