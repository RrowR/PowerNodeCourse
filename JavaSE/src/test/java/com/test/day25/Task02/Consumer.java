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
                LockUtils.lock_producer.signalAll();
                LockUtils.lock_consumer.await();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LockUtils.LOCK.unlock();
            }
        }
    }
}
