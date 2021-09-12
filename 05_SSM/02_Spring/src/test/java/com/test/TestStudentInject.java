package com.test;

import com.study.domain.TestInjectUser01;
import com.study.domain.TestInjectUser02;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    测试向ioc容器里给对象注入值
 */
public class TestStudentInject {
    @Test
    void Test01(){
        /*
            方式1：使用构造方法的方式向对象注入值
            注意:使用构造方法来进行构造的时候，实体类里必须要有对应参数的构造方法
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TestInjectUser01 bean = context.getBean(TestInjectUser01.class);
        System.out.println(bean);
        // 如果这里使用id来获取，那么spring不知道这个是什么对象，只能使用强转才可以，但是我们作为上帝视角是知道的
        Object bean2 = context.getBean("testConstructorInject1_2");
        System.out.println("bean2 = " + bean2);
    }

    @Test
    void Test02(){
        /*
            使用Set方法进行注入
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TestInjectUser02 bean = context.getBean(TestInjectUser02.class);
        System.out.println("bean = " + bean);
    }
}
