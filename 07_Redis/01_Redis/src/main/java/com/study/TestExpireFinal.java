package com.study;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExpireFinal {

    private static Map<String, Object> redis = new HashMap<>();

    private static Map<String, Long> expire = new HashMap<>();

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            5,
            8,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    static {
        threadPool.submit(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我睡了十秒了");
                expire.forEach((k, v) -> {
                    if (System.currentTimeMillis() > v) {
                        redis.remove(k);
                    }
                });
            }
        });
    }

    public static void set(String key, Object value, Long expireTime) {
        redis.put(key, value);
        if (expireTime != null) {
            expire.put(key, System.currentTimeMillis() + expireTime);
        }
    }


    public static Object get(String key) {
        //记得惰性删除的要点
        if (expire.containsKey(key)) {
            //就看key是否过期
            Long time = expire.get(key);
            if (System.currentTimeMillis() > time) {
                //过期了
                redis.remove(key);
                expire.remove(key);
            }
        }
        return redis.get(key);
    }

    public static void main(String[] args) {
        set("test", "test", 6500L);
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object test = get("test");
            System.out.println(test);
        }
    }
}
