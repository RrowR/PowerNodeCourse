package com.study;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *  用来增强的类
 */
public class MyAdvice {
    public void beforeAdvice(){
        System.out.println("前置增强");
    }
    public void afterAdvice(){
        System.out.println("后置增强!!!");
    }

    /*
    *   这个增强的环绕方法需要有参数，否则不会执行被代理的方法
    * */
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        beforeAdvice();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        afterAdvice();
    }
}
