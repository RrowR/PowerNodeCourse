package com.study;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisOperation {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.72.128", 6380);
        jedis.auth("123456");
        jedis.set("first:name","猫羽雫");
        jedis.lpush("love","name mimi");
        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::println);
        jedis.close();
    }
}
