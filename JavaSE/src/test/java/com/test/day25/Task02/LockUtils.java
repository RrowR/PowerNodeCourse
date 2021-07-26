package com.test.day25.Task02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUtils {
    // 这里的锁是LockUtils，这个对象是固定的
    public static final Lock LOCK = new ReentrantLock();
    // 使用LockUtils这把锁创建2个监视器
    public static final Condition lock_producer = LOCK.newCondition();
    public static final Condition lock_consumer = LOCK.newCondition();
}
