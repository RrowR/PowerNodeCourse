package com.study;

public interface ITargetClass {
    // 前置增强的接口
    void beforeMethod();
    // 后置增强的接口
    void afterMethod();
    // 环绕增强的接口
    void aroundMethod();
}
