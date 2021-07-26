package com.test.day25.Task02;

import java.util.LinkedList;

public class Producer implements Runnable {
    int count = 0;
    LinkedList<Food> list;

    public Producer(LinkedList<Food> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            // 使用这个工具类做为锁
            try {
                LockUtils.LOCK.lock();
                if (list.size() == 10) {
                    /*
                        Condition newCondition() 返回用来与此 Lock 实例一起使用的 Condition 实例。
                           void await() 造成当前线程在接到信号或被中断之前一直处于等待状态。
                           boolean await(long time, TimeUnit unit) 造成当前线程在接到信号、被中断或到达指定等待时间之前一直处于等待状态。
                           void signal() 唤醒一个等待线程。
                           void signalAll() 唤醒所有等待线程。
                     */
                    // 当生产的数量到达10个时，停止生产者，唤醒所有消费者
                    LockUtils.lock_consumer.signalAll();
                    LockUtils.lock_producer.await();
                } else {
                    if (count++ % 2 == 0) {
                        Food food = new Food("水晶", "包子");
                        list.add(food);
                        System.out.println("生产了" + food.getName() + food.getType());
                        Thread.sleep(200);
                    } else {
                        Food food = new Food("北京", "烤鸭");
                        list.add(food);
                        System.out.println("生产了" + food.getName() + food.getType());
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LockUtils.LOCK.unlock();
            }
        }
    }
}
