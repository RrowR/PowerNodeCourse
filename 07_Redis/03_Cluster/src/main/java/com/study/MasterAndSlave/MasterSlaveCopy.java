package com.study.MasterAndSlave;

import redis.clients.jedis.Jedis;

public class MasterSlaveCopy {
    public static void main(String[] args) {
        Jedis jedis_01 = new Jedis("192.168.72.128", 6379);
        Jedis jedis_02 = new Jedis("192.168.72.128", 6380);
        jedis_02.auth("123456");
        jedis_02.slaveof("192.168.72.128",6379);
        jedis_01.set("kora","kora is mine");
        System.out.println(jedis_02.get("kora"));

    }
}
