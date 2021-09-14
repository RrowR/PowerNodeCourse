package day24.afternoon;


public class Consumer implements Runnable {

    Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        while (true){
            synchronized (food) {
                if (food.isFlag() == true) {
                    System.out.println(Thread.currentThread().getName() + " 消费者消费了：" + food.getName() + food.getType());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    food.setFlag(false);
                }else {
                    try {
                        food.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                food.notify();
            }
        }
    }
}
