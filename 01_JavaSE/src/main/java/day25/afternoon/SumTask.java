package day25.afternoon;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        return sum;
    }
}
