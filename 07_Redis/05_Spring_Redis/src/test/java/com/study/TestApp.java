package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestApp {
    @Test
    void SpringRedis(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-redis.xml");
        JedisPool jedisPool = context.getBean(JedisPool.class);
        Jedis jedis = jedisPool.getResource();
        jedis.set("k1","v1");
        System.out.println(jedis.get("k1"));
        jedis.close();
    }
}
