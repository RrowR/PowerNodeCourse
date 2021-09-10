package com.test;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    void TestBean(){
        // 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // 从容器中获取对象,这里使用类名还是使用id都是可以的
        Object user = context.getBean("userId");
        System.out.println(user);
    }
}
