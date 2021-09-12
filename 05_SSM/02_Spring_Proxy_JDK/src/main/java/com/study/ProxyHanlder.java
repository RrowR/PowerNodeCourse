package com.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 实现jdk自带的InvocationHandler接口
public class ProxyHanlder implements InvocationHandler {

    // 目标对象
    private Object tarObj;

    public ProxyHanlder(Object tarObj) {
        this.tarObj = tarObj;
    }

    /**
     *
     * @param proxy  生成的代理类的对象
     * @param method  目标类中被代理的方法
     * @param args    目标类中被代理的方法实际参数
     * @return      可以当做目标方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 使用目标类中代理的方法去调用调用方法的目标，并且传递参数(反射)
        return method.invoke(tarObj,args);
    }
}
