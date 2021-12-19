package com.study.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    // 设置切点
    public final String pointCut = "execution(* com.study.bean.User.*(..))";

    @Before(value = pointCut)
    public void before(){
        System.out.println("我先洗手");
    }

//    @After(value = pointCut)
//    public void after(){
//        System.out.println("我吃完洗碗");
//    }
//
//    @Around(value = pointCut)
//    public void around(ProceedingJoinPoint joinPoint){
//        System.out.println("先娱乐去了");
//        try {
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("娱乐结束了");
//    }
//
//    @AfterThrowing(value = pointCut,throwing = "aaa")
//    public void afterThrowing(Throwable aaa){
//        System.out.println("出现异常了。。。。"+aaa.getMessage());
//    }

}
