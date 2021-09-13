package com.study.impl;

import com.study.ITargetClass;

public class TargetClass implements ITargetClass {
    @Override
    public void beforeMethod() {
        System.out.println("前置待增强的方法...");
    }

    @Override
    public void afterMethod() {
        System.out.println("带增强的后置方法...");
    }


    @Override
    public void aroundMethod() {
        System.out.println("我是一个环绕方法");
    }

    @Override
    public void excetionMethod() {
        System.out.println("我是一个出现异常方法");
        int a = 10/0;
    }


}
