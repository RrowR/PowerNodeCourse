package com.study.Utils;

import redis.clients.jedis.Jedis;

public class JedisUtils {

    private static String host = "192.168.72.128";

    private static Jedis jedis = new Jedis(host,6380);

    public static Jedis getJedis(){
        jedis.auth("123456");
        return jedis;
    }
}
