package com.test;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    void TestBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Object user = context.getBean("user");
        System.out.println(user);
    }
}
