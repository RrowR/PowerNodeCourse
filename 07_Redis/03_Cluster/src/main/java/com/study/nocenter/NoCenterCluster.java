package com.study.nocenter;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class NoCenterCluster {
    public static void main(String[] args) {
        final String host = "192.168.72.128";
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort(host,7001));
        nodes.add(new HostAndPort(host,7002));
        nodes.add(new HostAndPort(host,7003));
        nodes.add(new HostAndPort(host,7004));
        nodes.add(new HostAndPort(host,7005));
        nodes.add(new HostAndPort(host,7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("k1","v1");
        System.out.println(jedisCluster.get("k1"));
    }
}
