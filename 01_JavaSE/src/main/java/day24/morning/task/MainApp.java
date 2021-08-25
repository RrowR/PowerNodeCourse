package day24.morning.task;

public class MainApp {
    public static void main(String[] args) {
        TicketSaleThread ticketSaleThread = new TicketSaleThread();
        Thread t1 = new Thread(ticketSaleThread);
        Thread t2 = new Thread(ticketSaleThread);
        Thread t3 = new Thread(ticketSaleThread);
        t1.start();
        t2.start();
        t3.start();
    }
}
