package com.test.day99finalTask.task03;

/**
 * 编写多线程程序，模拟多个人通过一个山洞的模拟。这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，有10个人同时准备过此山洞，显示每次通过山洞人的姓名和顺序。
 */
public class Task01 {
    static Cave cave = new Cave();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            new Thread(() -> cave.passCave(),"线程" + i).start();
        }
    }
}

class Cave{
    void passCave(){
        // 每个线程都会来调用这个方法，但是Cave只有一个，所以可以用这个对象当作锁
        synchronized (this){
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(Thread.currentThread().getName() + "走啊走走啊走...走了");
                    System.out.println(i + "秒");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
