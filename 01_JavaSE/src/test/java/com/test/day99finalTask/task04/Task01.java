package com.test.day99finalTask.task04;

/**
 * 4.	多线程
 * 写一个死锁的代码
 */
public class Task01 {

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> deadLock()).start();
        new Thread(() -> deadLock02()).start();
    }

    private static void deadLock02() {
        synchronized (o2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    private static void deadLock() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                for (int i = 1; i <= 100; i++) {
                    System.out.println(i);
                }
            }
        }
    }

}




