package day24.morning.task2.improvement;

import java.util.concurrent.locks.Lock;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        int sumary = 0;
        Object o = new Object();
        for (int i = 0; i < 10; i++) {
            // 这里的构造方法和i联系了起来，不同i对应不同区间的值，内部方法再进行遍历求和

            SumThread sumThread = new SumThread(i * 1000 + 1, (i + 1) * 1000);
            Thread thread = new Thread(sumThread);
            thread.start();
            thread.join();
            int result;
                result = sumThread.getResult();
            sumary += result;
//            System.out.println(result);
        }
        System.out.println(sumary);
    }
}
