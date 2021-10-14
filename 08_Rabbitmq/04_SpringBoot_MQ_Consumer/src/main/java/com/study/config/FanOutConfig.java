package com.study.config;

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
}
