package com.test;

import com.study.PointedExceptionDomain;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionAdvice {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PointedExceptionDomain bean = context.getBean(PointedExceptionDomain.class);
        bean.excptionExtensions();
    }
}
