package com.test.day25.Task03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            实现Callable接口的类想要实现多线程只能让线程池来调用，使用get方法来获取这个线程的返回值
            拿到结果之后注意要关闭线程池，否则线程池将一直等待接收要执行的实现Callable接口里的run方法的那个类
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> submit = executorService.submit(new SumMethod());
        // Attempts to cancel execution of this task
//        submit.cancel(true);
//        System.out.println(submit.get());       // 当上面取消之后，再执行获取可能会报错
        System.out.println(submit.isDone());        // 这里是执行get方法之后才执行run方法，get之前返回false，之后返回true
        executorService.shutdown();
    }
}
