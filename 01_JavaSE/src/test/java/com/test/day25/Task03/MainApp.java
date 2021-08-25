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
            boolean cancel(boolean mayInterruptIfRunning) 试图取消对此任务的执行。
            V get() 如有必要，等待计算完成，然后获取其结果。
            V get(long timeout, TimeUnit unit) 如有必要，最多等待为使计算完成所给定的时间之后，获取其结果（如果结果可用）。
            boolean isCancelled() 如果在任务正常完成前将其取消，则返回 true。
            boolean isDone() 如果任务已完成，则返回 true。

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
