package com.test.day25.Task06;

import java.util.concurrent.Semaphore;

/**
 *  构造方法：
 *  Semaphore(int permits)
 *           创建具有给定的许可数和非公平的公平设置的 Semaphore。
 *  Semaphore(int permits, boolean fair)
 *           创建具有给定的许可数和给定的公平设置的 Semaphore。
 *
 *  void acquire()
 *           从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
 *  void release()
 *           释放一个许可，将其返回给信号量。
 */
public class MainApp {
    public static void main(String[] args) {
        /*
            主要是为了控制线程在一定时间内执行的个数，当满5个的时候，其他线程阻塞
            注意：无法保证线程安全

            只有获得relase（类似于许可）的线程才可以继续执行，否则都会在acquire上阻塞
         */
        // 车库数
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("车辆进来了");
                    semaphore.release();
                    System.out.println("车辆出去了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
