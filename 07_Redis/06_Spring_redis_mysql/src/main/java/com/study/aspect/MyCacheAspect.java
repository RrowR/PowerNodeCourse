package com.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Aspect
@Component
@EnableAspectJAutoProxy
public class MyCacheAspect {
    @Autowired
    private JedisPool jedisPool;

    public static final String INSERT_POINTCUT = "execution(* com.study.service.impl.UserServiceRedisAspectImpl.insert(..))";
    public static final String DEL_POINTCUT = "";
    public static final String UPDATE_POINTCUT = "";
    public static final String QUERY_ONE_POINTCUT = "";
    public static final String QUERY_ALL_POINTCUT = "";

    @Around(value = INSERT_POINTCUT)
    public Object insertCacheAspect(ProceedingJoinPoint joinPoint){
        // 获得方法签名
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        return null;
    }


}
