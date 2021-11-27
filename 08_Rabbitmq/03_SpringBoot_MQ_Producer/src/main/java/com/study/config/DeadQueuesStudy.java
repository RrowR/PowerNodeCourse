package com.study.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DeadQueuesStudy {

    /**
     * 延迟队列
     * @return
     */
    @Bean
    public Queue msQueue() {
        Map<String, Object> args = new HashMap<>();
        // 设置延迟的时间 设置消息死亡后走哪个交换机  走哪个路由key
        args.put("x-message-ttl", 20000);       // 20秒
        args.put("x-dead-letter-exchange", "deadEx");
        args.put("x-dead-letter-routing-key", "deadKey");

        return new Queue("ms.dead.queue", true, false, false, args);
    }

    @Bean
    public DirectExchange deadEx() {
        return new DirectExchange("deadEx");
    }

    @Bean
    public Queue deadQueue() {
        return new Queue("deadQueue");
    }

    @Bean
    public Binding deadBind() {
        return BindingBuilder.bind(deadQueue()).to(deadEx()).with("deadKey");
    }






}
