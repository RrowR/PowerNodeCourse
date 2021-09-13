package com.test;

import com.study.ITargetClass;
import com.study.impl.TargetClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  Aspects也是基于接口来增强的...
 *      在原生的spring中，每种增强都需要单独定义一个类实现相应的接口。
 *      增强类本身就更庞大，而且方法的名称是固定的。
 *      基于这种情况，AspectJ提供了相对更加灵活的方式。
 *      在AspectJ中，只需要定义一个增强类即可，并且方法的名称可以任意定义。
 */
public class TestAspectJ {
    /*
        测试前置增强
     */
    @Test
    void MethodBefore(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        ITargetClass proxy = context.getBean(ITargetClass.class);
        proxy.beforeMethod();
    }

    /*
        后置增强
     */
    @Test
    void MethodAfter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        ITargetClass proxy = context.getBean(ITargetClass.class);
        System.out.println("bean = " + proxy.getClass().getSimpleName());
        proxy.afterMethod();
    }

    /*
        环绕增强
     */
    @Test
    void MethodAround(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        ITargetClass proxy = context.getBean(ITargetClass.class);
        proxy.aroundMethod();
    }

}
