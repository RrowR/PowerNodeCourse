package com.test;
import com.study.MyMethodInterceptor;
import com.study.TargetClass;
import net.sf.cglib.proxy.Enhancer;

/*
    Cglib是基于继承的方式来实现扩展
 */
public class TestCglib {
    public static void main(String[] args) {
        // 增强工具类，等下可以创建代理对象
        Enhancer enhancer = new Enhancer();
        // 给增强类设置一个爸爸
        enhancer.setSuperclass(TargetClass.class);
        // 给增强类设置调用时的回调
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建父类代理对象
        TargetClass proxy = (TargetClass) enhancer.create();
        proxy.rent();
    }
}
