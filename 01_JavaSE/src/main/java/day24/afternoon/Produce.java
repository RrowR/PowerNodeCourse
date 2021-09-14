package day24.afternoon;

public class Produce implements Runnable {

    int count = 0;

    Food food;

    public Produce(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        while (true){
            synchronized (food){
                if (food.isFlag() == false){
                    if (count++ % 2 == 0){
                        food.setName("光明");
                        food.setType("牛奶");
                        System.out.println(Thread.currentThread().getName() + "生产者生产了" + "光明牛奶");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        food.setName("曹县");
                        food.setType("三鲜");
                        System.out.println(Thread.currentThread().getName() + "生产者生产了" + "曹县三鲜");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    food.setFlag(true);
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
