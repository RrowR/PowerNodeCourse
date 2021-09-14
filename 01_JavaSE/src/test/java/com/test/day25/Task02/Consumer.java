package com.test.day25.Task02;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    LinkedList<Food> list;

    public Consumer(LinkedList<Food> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
            LockUtils.LOCK.lock();
                while (list.size() != 0){
                    Food food = list.removeLast();
                    System.out.println("吃了"+food.getType()+food.getName());
                    Thread.sleep(200);
                }
                // 这里的顺序一定不能反，在这种业务代码下，必须先唤醒别的线程，再让自己阻塞
//                LockUtils.lock_consumer.await();
                // 这里只需要单向唤醒即可（根据代码的业务来）
                LockUtils.lock_producer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LockUtils.LOCK.unlock();
            }
        }
    }
}
