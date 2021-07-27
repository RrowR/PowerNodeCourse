package com.test.day25.Task07;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  使用Timer来定时执行某个任务
 *  构造方法：
 *      public Timer(boolean isDaemon)  是否开启为守护线程
 *
 *  成员方法:
 *      void schedule(TimerTask task,Date firstTime,long period) 设置开始时间和执行周期自动地运行代码
 *      Schedules the specified task for repeated fixed-delay execution, beginning at the specified time.
 *
 *
 */
public class MainApp {
    public static void main(String[] args) {
        Timer timer = new Timer();      // 可以开启是否为守护线程
        timer.schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("TimerTask执行了！！！   "+ i++);
            }
        }, new Date(), 2000);


    }
}
