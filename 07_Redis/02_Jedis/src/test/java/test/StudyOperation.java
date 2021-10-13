package test;

import com.study.Utils.JedisUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class StudyOperation {
    @Test
    void flushKeys(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.flushAll();
        jedis.close();
    }

    @Test
    void zsetKeys(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.zadd("user1",10d,"maomao");
        jedis.zadd("user1",12d,"gougou");
        jedis.zadd("user1",11d,"catcat");
        Set<String> set = jedis.zrange("user1", 0, -1);
        set.forEach(System.out::println);

        jedis.close();
    }

    /*
        hash <key,Map<key,value>>
     */
    @Test
    void hashKeys(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.hset("user","name","shark");
        System.out.println(jedis.type("user"));
        System.out.println(jedis.hget("user", "name"));
        HashMap<String, String> map = new HashMap<>();
        map.put("birth","today");
        map.put("name","moli");
        map.put("age","16");
        jedis.hset("otherUser",map);
        System.out.println(jedis.hget("otherUser", "name"));
        List<String> list = jedis.hmget("otherUser", "name","birth","age");
        list.forEach(System.out::println);
        jedis.close();
    }

    /*
        list
     */
    @Test
    void listKeys(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.lpush("num",String.valueOf(Arrays.asList(1,2,3,4,5,6)));
        System.out.println(jedis.lrange("num", 0, -1));
        jedis.close();
    }

    /*
        set
     */
    @Test
    void setSet(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.sadd("name","猫羽雫","镜华","美美");
        jedis.srem("name","镜华");
        System.out.println(jedis.smembers("name"));
        System.out.println(jedis.smembers("name").size());
        jedis.close();
    }

    /*
        key
     */
    @Test
    void setKeys(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("t1","v1");
        Long ttl = jedis.ttl("t1");
        System.out.println(ttl);
        System.out.println(jedis.exists("t1"));
        jedis.setex("t2",100,"v2");
        System.out.println(jedis.ttl("t2"));
        jedis.setex("t3",100,"v3");
        System.out.println(jedis.ttl("t3"));
        jedis.close();
    }

    @Test
    void getAllKeys(){
        Jedis jedis = JedisUtils.getJedis();
        System.out.println(jedis.keys("*"));
        jedis.close();
    }

    /*
        mset
     */
    @Test
    void mset(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.mset("k1","v1","k2","v2","k3","v3");
        jedis.close();
    }

    @Test
    void judge(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.exists("t2");         // 验证redis里的key是否存在
        jedis.close();
    }
}
