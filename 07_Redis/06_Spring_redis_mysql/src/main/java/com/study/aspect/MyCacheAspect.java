package com.study.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

//    // 对插入方法进行切入
//    @Around(value = INSERT_POINTCUT)
//    public Object insertCacheAspect(ProceedingJoinPoint joinPoint){
//        // 获得目标方法的入参,就是方法传递过来的参数，比如我传递一个对象，那么入参就是这个对象
//        Object[] args = joinPoint.getArgs();
//        System.out.println("args.toString() = " + args.toString());
//        System.out.println("args[0] = " + args[0]);
//        // 获得方法签名
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        // 从签名中获得方法
//        Method method = signature.getMethod();
//        System.out.println("method.getName() = " + method.getName());
//        // 拿到目标对象
//        Object target = joinPoint.getTarget();
//        System.out.println("target.getClass().getSimpleName() = " + target.getClass().getSimpleName());
//        // 拿到目标的class文件
//        Class<?> clazz = joinPoint.getTarget().getClass();
//        try {
//            // 获取目标对象里的指定名字的属性
//            Field field = clazz.getDeclaredField("userAllPrefix");
//            // 设置访问权限为true
//            field.setAccessible(true);
//            // 拿到属性的属性值
//            String fieldValue = field.get(target).toString();
//            System.out.println("fieldValue = " + fieldValue);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Object result = null;
//        try {
//            // 执行目标方法,传入的就是入参数，这里插入传入的就是插入的对象
//            result = joinPoint.proceed(args);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return result;
//    }


    /*
        使用切面的方式来添加缓存
     */
    @Around(value = INSERT_POINTCUT)
    public Object insertCacheAspect(ProceedingJoinPoint joinPoint){
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        // 拿到缓存前缀
        String cachePrefix = getCachePredis(joinPoint);
        // 删除所有缓存
        jedis.del(cachePrefix+"all");
        // 执行目标方法
        Object[] args = joinPoint.getArgs();
        try {
            // 执行目标方法,这里的返回值是目标方法的返回值
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (result != null && Integer.parseInt(result.toString()) > 0){
            // 获得目标方法的入参，在这个插入方法中是一个需要插入的对象
            Object arg = args[0];
            Object id = getObjId(arg);
            jedis.set(cachePrefix+id, JSON.toJSONString(arg));
        }
        jedis.close();
        return result;
    }

    private Object getObjId(Object obj) {
        Object id = null;
        try {
            Field field = obj.getClass().getDeclaredField("id");
            field.setAccessible(true);
            id = field.get(obj);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private String getCachePredis(ProceedingJoinPoint joinPoint) {
        String cachePrefix = null;
        try {
            Object target = joinPoint.getTarget();
            Field field = target.getClass().getDeclaredField("userPrefix");
            field.setAccessible(true);
            cachePrefix = field.get(target).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cachePrefix;
    }


}
