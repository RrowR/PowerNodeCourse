package com.test;

import com.study.PointedDomain;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterAdviceByEntity {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PointedDomain bean = context.getBean(PointedDomain.class);
        System.out.println("bean = " + bean.getClass().getSimpleName());
        bean.hawl();
    }
}
