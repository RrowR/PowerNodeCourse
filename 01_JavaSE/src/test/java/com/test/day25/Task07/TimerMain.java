package com.test.day25.Task07;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 使用Timer来定时执行某个任务
 * 构造方法：
 * public Timer(boolean isDaemon)  是否开启为守护线程
 * <p>
 * 成员方法:
 * void schedule(TimerTask task,Date firstTime,long period) 设置开始时间和执行周期自动地运行代码
 * Schedules the specified task for repeated fixed-delay execution, beginning at the specified time.
 */
public class TimerMain {
    @Test
    public void timerAutoExecute() throws InterruptedException {
        Timer timer = new Timer();      // 可以开启是否为守护线程
        timer.schedule(new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                System.out.println("TimerTask执行了！！！   " + i++);
            }
        }, new Date(), 2000);
        // 让这个线程执行完毕，可是这个线程里的定时任务是一个永不结束的任务，所以不可能停止，解决了junit环境下timer.schedule()不能一直运行的问题
        Thread.currentThread().join();
    }

    @Test
    public void timerSumNum() throws InterruptedException {
        Timer timer = new Timer("定时器线程", true);
        // 使用 闭锁 可以解决junit下多线程问题闭锁
        CountDownLatch countDownLatch = new CountDownLatch(100);
        LinkedList<Integer> linkedList = new LinkedList<>();
//        Vector<Integer> vector = new Vector<>();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();
//                linkedList.add(random.nextInt(1000)+10);
                linkedList.add(random.nextInt(1000) + 10);
                System.out.println(linkedList.size());
                countDownLatch.countDown();
            }
        }, new Date(), 1);

        // 达到指定数量才放行
        countDownLatch.await();
    }

    @Test
    public void threadLocal() {
        /*
           构造方法：
            ThreadLocal() 创建一个线程本地变量
           实例方法：
                T get() 返回此线程局部变量的当前线程副本中的值。
                protected  T initialValue() 返回此线程局部变量的当前线程的“初始值”。
                void remove() 移除此线程局部变量当前线程的值。
                void set(T value) 将此线程局部变量的当前线程副本中的值设置为指定值。


         */
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(20);
        // 主线程来获取当前threadLocal线程中的值
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());     // main:20
    }


}
