package com.study;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceRedisAspectImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

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

    @Test
    void TestDeleleById(){
        service.deleteByPrimaryKey(7);
        System.out.println("delete success");
    }

    @Test
    void TestQueryBySelective(){
        User user = service.selectByPrimaryKey(6);
        System.out.println(user);
    }

    @Test
    void TestQueryAll(){
        List<User> users = service.selectAll();
        System.out.println(users);
    }

    @Test
    void TestUpdate(){
        int i = service.updateByPrimaryKeySelective(User.builder().id(6).name("maomao").address("dream").birth(new Date()).build());
        System.out.println(i);
    }
}
