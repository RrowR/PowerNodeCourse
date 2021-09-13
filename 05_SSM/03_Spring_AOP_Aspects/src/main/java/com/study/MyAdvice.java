package com.study;

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
}
