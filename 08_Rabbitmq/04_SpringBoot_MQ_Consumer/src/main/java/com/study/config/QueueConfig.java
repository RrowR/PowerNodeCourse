package com.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    生产者和消费者来创建queue都是可以的
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue helloQueue(){
        return new Queue("spring-boot");
    }



}
