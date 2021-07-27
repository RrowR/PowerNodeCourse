package com.test.day25.Task04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        /*
            CountDownLatch(int count) 构造一个用给定计数初始化的 CountDownLatch
                void await() 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
                boolean await(long timeout, TimeUnit unit) 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。
                void countDown() 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
                long getCount() 返回当前计数。
                String toString() 返回标识此锁存器及其状态的字符串。

         */
        CountDownLatch countDownLatch = new CountDownLatch(30);
        for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                new Thread(() -> {
                    System.out.println("进来了一个学生....");
                    countDownLatch.countDown();
                }).start();

        }
        //  如果CountDownLatch不执行到0，那么主线程将不会被唤醒
        System.out.println("主线程阻塞");
        countDownLatch.await();
        System.out.println("主线程被唤醒");
    }
}
