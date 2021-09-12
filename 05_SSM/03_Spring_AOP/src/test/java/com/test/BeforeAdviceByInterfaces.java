package com.test;

import com.study.interfaces.ITargetClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAdviceByInterfaces {
    @Test
    void TestBeforeAdvice(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // 如果使用的是接口实现的方式，这里只能使用传接口才可以
        ITargetClass bean = context.getBean(ITargetClass.class);
        // 有接口使用jdk的动态代理，没有使用cglib的动态代理
        System.out.println("bean = " + bean.getClass().getSimpleName());
        bean.targetMethod();
    }
}
