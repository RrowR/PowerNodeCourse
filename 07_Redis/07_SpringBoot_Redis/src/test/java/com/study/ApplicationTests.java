package com.study;

import com.study.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 这个速度会快，但是比上面麻烦，不是重点大概占比5%
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testStringRedisTemplateGetOpsForValue() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String v1 = ops.get("k1");
        System.out.println(v1);
    }

    @Test
    void testStringRedisTemplateSetOpsForValue() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("k1","v1",30, TimeUnit.SECONDS);
    }

    @Test
    void testStringRedisTemplateSetOpsForList(){
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        list.leftPush("k1", "v2");
    }

    @Test
    void testStringRedisTemplateSetopsForHash(){
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
//        Boolean key = hash.hasKey("mm", "roro");
        hash.put("k2","name","mm");
        System.out.println(hash.get("k2", "name"));
    }

    @Test
    void StringTemplateSetOpsForSet(){
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        set.add("ddd","ddkdkdk");
    }

    @Test
    void StringTemplateSetOpsForZset(){
        ZSetOperations<String, String> zSet = stringRedisTemplate.opsForZSet();
        zSet.add("zset","zzz1",100);
        zSet.add("zset","zzz2",101);
        zSet.add("zset","zzz3",102);
        Set<String> zset = zSet.range("zset", 0L, -1L);
        System.out.println(zset);
        Long zset1 = zSet.removeRangeByScore("zset", 100, 101);
        System.out.println(zset1);

    }

    @Test
    void redisTemplateOpsForValue(){
        // 通过RedisTemplate放进去的值在another Redis Desktop Manager里是看不见的(帮我们序列化了)，因为已经被转成了二进制数据，但是执行效率很高
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("qwe","ert");
    }

    @Test
    void redisTemplateForSerializer(){
        // 先手动将key序列化成json格式
        redisTemplate.setKeySerializer(RedisSerializer.string());
        // 将value序列化成json的格式
        redisTemplate.setValueSerializer(RedisSerializer.json());
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("user",User.builder()
            .name("猫羽雫")
            .age(16)
            .hooby(Arrays.asList("sleep","adorable","blue","nya"))
            .birth(new Date()).build()
        );

        Object user = ops.get("user");
        System.out.println(user);
    }

}
