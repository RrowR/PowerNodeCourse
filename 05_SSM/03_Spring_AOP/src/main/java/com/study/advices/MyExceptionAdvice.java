package com.study.advices;

import org.springframework.aop.ThrowsAdvice;

public class MyExceptionAdvice implements ThrowsAdvice {
    // 异常增强中的增强方法必须叫：afterThrowing，并且必须定义参数接收发生的异常信息
    // 搞不懂为什么不让我去实现呢，还要手动去写
    public void afterThrowing(Exception ex){
        System.out.println("异常增强的方法。。。");
    }
}
