package com.study.impl;

import com.study.ITargetClass;

public class TargetClass implements ITargetClass {
    @Override
    public void beforeMethod() {
        System.out.println("前置待增强的方法...");
    }
}
