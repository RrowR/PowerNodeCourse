package com.study.advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyRoundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前置通知");
        Object proceed = methodInvocation.proceed();
        System.out.println("后置通知");
        return proceed;
    }
}
