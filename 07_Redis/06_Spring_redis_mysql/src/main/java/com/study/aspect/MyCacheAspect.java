package com.study.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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

    public static final String INSERT_POINTCUT = "execution(* com.study.service.impl.*.insert(..))";
    public static final String DEL_POINTCUT = "execution(* com.study.service.impl.*.deleteByPrimaryKey(..))";
    public static final String UPDATE_POINTCUT = "execution(* com.study.service.impl.*.updateByPrimaryKeySelective(..))";
    public static final String QUERY_ONE_POINTCUT = "execution(* com.study.service.impl.*.selectByPrimaryKey(..))";
    public static final String QUERY_ALL_POINTCUT = "execution(* com.study.service.impl.*.selectAll(..))";

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
    public Object insertCacheAspect(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        // 拿到缓存前缀
        String cachePrefix = getCachePredis(joinPoint);
        // 删除所有缓存
        jedis.del(cachePrefix + "all");
        // 执行目标方法的参数
        Object[] args = joinPoint.getArgs();
        try {
            // 执行目标方法,这里的返回值是目标方法的返回值
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (result != null && Integer.parseInt(result.toString()) > 0) {
            // 获得目标方法的入参，在这个插入方法中是一个需要插入的对象
            Object arg = args[0];
            Object id = getObjId(arg);
            jedis.set(cachePrefix + id, JSON.toJSONString(arg));
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

    @Around(value = DEL_POINTCUT)
    public Object deleteByKeyAspect(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        Object[] args = joinPoint.getArgs();
        // 拿到删除的id
        String id = args[0].toString();
        String prefix = getCachePredis(joinPoint);
        jedis.del(prefix + id);
        jedis.del(prefix + "all");
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        jedis.close();
        System.out.println(result);
        return result;
    }

    @Around(value = QUERY_ONE_POINTCUT)
    public Object selectOne(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        String prefix = getCachePredis(joinPoint);
        Object[] args = joinPoint.getArgs();
        Object obj = args[0];
        String objStr = jedis.get(prefix + obj.toString());
        if (StringUtils.hasText(objStr)) {
            // 如果在缓存中查到有值(为什么要强转成MethodSignature 因为这个下级接口的方法多一些 Signature 太过顶层)
            MethodSignature signature = ((MethodSignature) joinPoint.getSignature());
            // 拿到返回值类型
            Class<?> returnType = signature.getMethod().getReturnType();
            // 直接从redis里拿，通过签名获得返回值类型，再通过fastjson来转成想要的对象
            result = JSON.parseObject(objStr, returnType);
        } else {
            // 查询数据库
            try {
                // 数据库返回什么，这里就返回什么
                result = joinPoint.proceed(args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if (!ObjectUtils.isEmpty(result)) {
                jedis.set(prefix + obj.toString(), JSON.toJSONString(result));
            }
        }
        jedis.close();
        // 这里可能是
        return result;
    }

    @Around(value = QUERY_ALL_POINTCUT)
    public Object queryAll(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Jedis jedis = jedisPool.getResource();
        String prefix = getCachePredis(joinPoint);
        String objListStr = jedis.get(prefix + "all");
        if (StringUtils.hasText(objListStr)) {
            // 将redis存储前缀改成全限定类名，通过 : 分割从而获得所在类的包名
            String[] split = prefix.split(":");
            // 拿到全限定类名
            String classForNameValue = split[0];
            // 这里接收必须是一个Class类型，不然下面的parseArray就会报错
            Class<?> clazz = null;
            try {
                // 通过类名来得到对象
                clazz = Class.forName(classForNameValue);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 将从redis里查出来的结果直接返回
            result = JSON.parseArray(objListStr, clazz);
        } else {
            try {
                result = joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if (!ObjectUtils.isEmpty(result)) {
                jedis.set(prefix + "all", result.toString());
            }
        }
        jedis.close();
        return result;
    }

    @Around(value = UPDATE_POINTCUT)
    public Object updateBySelective(ProceedingJoinPoint joinPoint) {
        Object result = null;
        Object[] args = joinPoint.getArgs();
        Jedis jedis = jedisPool.getResource();
        String prefix = getCachePredis(joinPoint);
        try {
            // 得到成功结果的个数
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (result != null && Integer.parseInt(result.toString()) > 0){
            // 获得目标方法的入参，在这个修改方法中是一个需要修改的对象
            Object updateUser = args[0];
            Object id = getObjId(updateUser);
            jedis.del(prefix+"all");
            jedis.set(prefix+id, JSON.toJSONString(updateUser));
        }
        jedis.close();
        return result;
    }

}
