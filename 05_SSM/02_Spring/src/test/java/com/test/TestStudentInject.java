package com.test;

import com.study.domain.TestInjectUser01;
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
    }
}
