package com.study;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * @param o 被代理类的对象
     * @param method    被代理的目标方法
     * @param objects   实际运行的参数
     * @param methodProxy   代理类对象
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置增强");
        // 注意这里是调用父类的方法
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("interceptor执行了");
        System.out.println("后置增强");
        return invoke;
    }
}
