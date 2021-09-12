package com.test;

import com.study.PointedExceptionDomain;
import com.study.interfaces.ITargetClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionAdvice {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
        PointedExceptionDomain bean = context.getBean(PointedExceptionDomain.class);
        bean.excptionExtensions();
    }
}
