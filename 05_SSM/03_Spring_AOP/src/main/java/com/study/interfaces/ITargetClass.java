package com.study.interfaces;

public interface ITargetClass {
    // 目标增强的方法
    void targetMethod();

    //
    String afterTargetMethod(String msg);

    void aroundTargetMethod();

    void runException();
}
