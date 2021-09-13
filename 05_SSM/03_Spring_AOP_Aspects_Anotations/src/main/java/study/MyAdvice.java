package study;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  用来增强的类
 */
@Component
@Aspect
public class MyAdvice {
    @Before(value = "execution(* study.impl.TargetClass.beforeMethod())")
    public void beforeAdvice(){
        System.out.println("前置增强");
    }
    @After(value = "execution(* study.impl.TargetClass.afterMethod())")
    public void afterAdvice(){
        System.out.println("后置增强!!!");
    }
    @Around(value = "execution(* study.impl.TargetClass.aroundMethod())")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        beforeAdvice();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        afterAdvice();
    }
    // 注意：异常注解这里要声明抛出的异常
    @AfterThrowing(value = "execution(* study.impl.TargetClass.excetionMethod())",throwing = "e")
    public void exceptionAdvice(Exception e){
        System.out.println("异常增强...");
    }
}
