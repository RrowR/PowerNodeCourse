package com.study.config;

import com.config02.Myconfig02;
import com.study.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import(Myconfig02.class)
public class Myconfig01 {

    @Bean(value = "user1")
    public User getUser1(){
        return new User("猫羽雫",16);
    }

    @Bean(value = "user2")
    public User getUser2(){
        return new User("nacacho",16);
    }

    @Bean(value = "user3")
    @Primary
    public User getUser3(){
        return new User("镜华",10);
    }
}
