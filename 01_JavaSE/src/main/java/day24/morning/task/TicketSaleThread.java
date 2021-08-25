package day24.morning.task;

public class TicketSaleThread implements Runnable{
    int ticket = 1000;
    @Override
    public void run() {
        while (ticket > 0){
            System.out.println("线程：" + Thread.currentThread().getName() + " 卖出了第" + ticket + "张票");
            ticket--;
        }
    }
}
