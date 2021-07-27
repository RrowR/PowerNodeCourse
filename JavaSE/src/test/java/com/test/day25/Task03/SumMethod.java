package com.test.day25.Task03;

import java.util.concurrent.Callable;

/*
    实现Callable接口实现有返回值的多线程方法
 */
public class SumMethod implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
