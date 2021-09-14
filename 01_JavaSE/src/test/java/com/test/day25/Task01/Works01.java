package com.test.day25.Task01;

import lombok.SneakyThrows;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;


public class Works01 {
    public static void main(String[] args) {
        /**
         *  使用定时器添加100条随机数
         */
        Vector<Integer> vector = new Vector<>();
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
        int count = 1;
            @Override
            public void run() {
                vector.add(new Random().nextInt(1000) + 1);
                System.out.println("添加了第"+ count++ +"次");
                if (vector.size() == 100) {
                    /*
                        void cancel() 终止此计时器，丢弃所有当前已安排的任务。
                     */
                    timer.cancel();
                }
            }
        }, new Date(), 10);

    }
}
