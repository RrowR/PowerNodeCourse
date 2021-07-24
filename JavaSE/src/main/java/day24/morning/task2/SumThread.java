package day24.morning.task2;

public class SumThread implements Runnable {
    int sum = 0;
    int num = 1;
    int flag;

    @Override
    public void run() {
        flag = (num + 1000);
        while (num <= 10000) {
            sum += num++;
            if (flag == num) {
                System.out.println(num);
                break;
            }
        }
    }
}
