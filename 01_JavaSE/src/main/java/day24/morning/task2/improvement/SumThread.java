package day24.morning.task2.improvement;

public class SumThread implements Runnable {
    private int max;
    private int min;
    private int sum;
    private int sum2;

    public SumThread() {
    }

    public SumThread(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public void run() {
        for (int i = min; i <= max; i++){
            sum += i;
        }
    }

    public int getResult(){
        // 这里要保证单个线程执行完毕才可以获取       join
        return sum;
    }
}
