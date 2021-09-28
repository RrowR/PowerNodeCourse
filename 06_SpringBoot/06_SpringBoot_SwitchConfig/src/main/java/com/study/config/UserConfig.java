package com.study.config;

import com.study.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UserConfig {
    /*
        配置不同频道下注入生效的对象
     */

    @Bean
    @Profile(value = "dev")
    public User user1(){
        return new User(1,"dev频道","wuhan");
    }

    @Bean
    @Profile(value = "pro")
    public User user2(){
        return new User(2,"pro频道","wuhan");
    }
}
