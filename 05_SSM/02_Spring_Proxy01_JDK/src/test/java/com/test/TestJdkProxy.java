package com.test;

import com.study.ProxyHanlder;
import com.study.interfaces.ItargetClass;
import com.study.interfaces.impl.TargetClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理的本质:
 * 传入对象的接口的实现类，传入到自己创建的代理处理器
 * 使用工具类创建一个代理对象，传入类加载器定位位置，这个接口实现类实现的接口数组,传入处理器
 * 代理对象调用被增强类的方法
 * 弊端:需要被代理的类需要有一个实现接口，自己需要为每个被增强的类创建一个处理器
 */
public class TestJdkProxy {
    @Test
    void TestJDKProxy(){
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 创建目标对象，不使用多态也是可以的
        ItargetClass itargetClass = new TargetClass();
        // 创建处理器,传入的是代理对象实现的接口
        ProxyHanlder proxyHanlder = new ProxyHanlder(itargetClass);
        // 调用Proxy类里的静态方法创建代理对象的实例，传入当前类的类加载器来定位，传入代理对象实现的接口数组，传入被代理对象（这里用了多态）
        ItargetClass proxy = (ItargetClass) Proxy.newProxyInstance(TestJdkProxy.class.getClassLoader(), new Class[]{ItargetClass.class}, proxyHanlder);
        // 这个创建出来的代理对象就可以使用被代理对象实现接口的方法了，中间还可以穿插自己的代码
        proxy.rent(100);
    }
}
