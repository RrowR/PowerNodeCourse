package com.test.day25.Task05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier(int parties)
 * 创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，但它不会在启动 barrier 时执行预定义的操作。
 * CyclicBarrier(int parties, Runnable barrierAction)
 * 创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，并在启动 barrier 时执行给定的屏障操作，该操作由最后一个进入 barrier 的线程执行。
 */
public class MainApp {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        // 10个线程结束才会执行 CyclicBarrier 里的方法，当10个线程结束就会调用CyclicBarrier里的接口中的方法，这个方法不需要使用Thread的start方法，如果次数超过10次，那么这第11个线程将会阻塞轮流到下次的10个才行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("CyclicBarrier里的方法执行了"));

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("第" + finalI + "次执行线程");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
