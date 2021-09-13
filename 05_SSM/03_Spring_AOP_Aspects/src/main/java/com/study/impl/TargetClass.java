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


}
