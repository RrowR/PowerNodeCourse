package com.study;

import redis.clients.jedis.Jedis;

public class JedisStudy {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.72.128", 6379);
        String pong = jedis.ping();
        jedis.close();
        System.out.println(pong);
    }
}
