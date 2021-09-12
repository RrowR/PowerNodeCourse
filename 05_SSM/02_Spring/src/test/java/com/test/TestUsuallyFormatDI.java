package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsuallyFormatDI {
    @Test
    void TestDI(){
        /*
            测试常用格式的依赖注入
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Object bean = context.getBean("person1");
        System.out.println("bean = " + bean);
    }
}
