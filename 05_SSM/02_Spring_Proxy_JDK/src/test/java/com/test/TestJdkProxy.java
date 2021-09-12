package com.test;

import com.study.ProxyHanlder;
import com.study.interfaces.ItargetClass;
import com.study.interfaces.impl.TargetClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class TestJdkProxy {
    @Test
    void TestJDKProxy(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 创建目标对象
        ItargetClass itargetClass = new TargetClass();
        // 创建处理器,传入的是代理对象实现的接口
        ProxyHanlder proxyHanlder = new ProxyHanlder(itargetClass);
        ItargetClass proxy = (ItargetClass) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(), new Class[]{ItargetClass.class}, proxyHanlder);
        proxy.rent(100);
    }
}
