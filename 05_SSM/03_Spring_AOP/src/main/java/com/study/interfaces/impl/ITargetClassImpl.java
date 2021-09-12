package com.study.interfaces.impl;

import com.study.interfaces.ITargetClass;

public class ITargetClassImpl implements ITargetClass {
    @Override
    public void targetMethod() {
        System.out.println("待增强的目标方法");
    }

    @Override
    public String afterTargetMethod(String msg) {
        System.out.println("afterTargetMethod");
        return null;
    }

    @Override
    public void aroundTargetMethod() {
        System.out.println("aroundTargetMethod");
    }

    @Override
    public void runException() {
        System.out.println("RunExcptions");
        int m = 0;
        int n = 100 / m;
    }
}
