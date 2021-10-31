package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import com.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
public class TestApplicationService {

    @Autowired
    private RedisTemplate redisTemplate;

    /*
        用户登陆首先将用户密码存到redis，redis的结构是<token,User>结构，然后将重要数据组装成一个map字符串返回
     */
    @GetMapping("doLogin")
    public String getToken(String username , String pwd){
        System.out.println(username);
        System.out.println(pwd);
        User user = new User(1, username, pwd);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        // 存入redis  (根据token存用户对象)
        redisTemplate.opsForValue().set(token,user.toString(), Duration.ofSeconds(7200));
        HashMap<String, Object> data = new HashMap<>();
        data.put("code",200);
        data.put("msg","ok");
        data.put("token",token);
        data.put("expire_in",7200);
        data.put("type","bearer");
        data.put("user",user);
        String s = JSON.toJSONString(data);
        return s;
    }
}
