package com.test;

import com.study.AroundPointedDomain;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 没有接口的时候就使用的是cglib代理
public class AroundAdviceByEntity {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
        AroundPointedDomain bean = context.getBean(AroundPointedDomain.class);
        System.out.println("bean = " + bean.getClass().getSimpleName());
        bean.hawl();
    }
}
