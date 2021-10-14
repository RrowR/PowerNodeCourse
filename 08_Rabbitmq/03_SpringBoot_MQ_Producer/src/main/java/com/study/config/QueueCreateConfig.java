package com.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueCreateConfig {
    @Bean
    public Queue createQueue(){
        return new Queue("spring.boot.queue");
    }
}
