package day24.afternoon;

public class MainApp {
    public static void main(String[] args) {
        Food food = new Food();
        Consumer consumer = new Consumer(food);
        Produce produce = new Produce(food);
        Thread t1 = new Thread(consumer,"comsumer线程1----> ");
        Thread t11 = new Thread(consumer,"comsumer线程11----> ");
        Thread t111 = new Thread(consumer,"comsumer线程111----> ");
        Thread t2 = new Thread(produce,"producer线程2----> ");
        Thread t22 = new Thread(produce,"producer线程22----> ");
        Thread t222 = new Thread(produce,"producer线程222----> ");
        t2.start();
        t222.start();
        t22.start();
        t1.start();
        t11.start();
        t111.start();

    }
}
