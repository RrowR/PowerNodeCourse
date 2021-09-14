package day25.afternoon;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  public interface ExecutorService extends ExecutorExecutor 提供了管理终止的方法，
 *  以及可为跟踪一个或多个异步任务执行状况而生成 Future 的方法。
 */
public class MainApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个实现了 Callable<Integer> 的对象
        SumTask sumTask = new SumTask();
        /*
           使用工具类创建线程池
            static ExecutorService newFixedThreadPool(int nThreads)
            创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*
            调用线程池里的sumbit方法，将实现了Runable的对象或者实现了Callable<T>的对象传进去,返回值是一个Future类型
            boolean cancel(boolean mayInterruptIfRunning) 试图取消对此任务的执行。
            V get() 如有必要，等待计算完成，然后获取其结果。
            V get(long timeout, TimeUnit unit) 如有必要，最多等待为使计算完成所给定的时间之后，获取其结果（如果结果可用）。
            boolean isCancelled() 如果在任务正常完成前将其取消，则返回 true。
            boolean isDone() 如果任务已完成，则返回 true。
         */
        // 调用 ExecutorService 里的submit方法，将写好的方法传入到 线程池 中去执行
        Future<Integer> submit = executorService.submit(sumTask);
        // 调用Future里get方法，返回Run方法里的返回值
        Integer result = submit.get();
        /*
            void shutdown()启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        抛出：
           SecurityException - 如果安全管理器存在并且关闭，此 ExecutorService 可能操作某些不允许调用者修改的线程
          （因为它没有保持 RuntimePermission("modifyThread")），或者安全管理器的 checkAccess 方法拒绝访问。
         */
        executorService.shutdown();
        System.out.println(result);


    }
}
