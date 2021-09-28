package com.config02;

import com.study.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Myconfig02 {

    @Autowired
    private User user;

    @Bean(value = "user4")
    public User getUser4(){
        return user;
    }
}
