package day24.morning.task2;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread = new SumThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(sumThread);
            thread.start();
            // 仔细分析这段代码，其实又是一个单线程了，不符合多线程 同时 执行的要求
            thread.join();
        }
        System.out.println(sumThread.sum);
    }
}
