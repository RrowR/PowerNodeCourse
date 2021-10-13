package com.study;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

    private static String host = "192.168.72.128";
    private static Integer port = 6379;

    private static JedisPool jedisPool;

    private static JedisPool getInstance(){
        if (jedisPool == null){
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 2000);
        }
        return jedisPool;
    }

    private static Jedis getJedis(){
        JedisPool jedisPool = getInstance();
        if (null != jedisPool){
            Jedis jedis = jedisPool.getResource();
            return jedis;
        }
        return null;
    }
}
