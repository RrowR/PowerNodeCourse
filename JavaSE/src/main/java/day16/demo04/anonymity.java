package day16.demo04;

// 匿名
public class anonymity {
    public static void main(String[] args) {
        new RunableInterface() {
            @Override
            public void run() {
                System.out.println("run...");
            }
        }.run();

        // 使用lambda,这里是某个实现类实现了接口才可以这样写， 单纯的接口不能 new 接口 的写法
        // 这里并没有一个需要传入接口的参数，而且本身这个方法是一个接口，不能这样使用lambda
/*        new RunableInterface(() -> {
            System.out.println("..run");
        }).run();*/

        // 正确写法
        RunableInterface run = () -> System.out.println("run....");
        run.run();

    }
}

