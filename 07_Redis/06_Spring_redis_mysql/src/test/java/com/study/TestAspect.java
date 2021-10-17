package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceRedisAspectImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestAspect {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    UserService service = context.getBean(UserService.class);

    @Test
    void TestInsertAspect(){
        service.insert(User.builder()
                .name("猫猫")
                .address("dream")
                .birth(new Date())
                .flag(1)
                .build()
        );
    }


}
