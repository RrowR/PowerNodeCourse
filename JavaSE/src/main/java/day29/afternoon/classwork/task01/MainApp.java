package day29.afternoon.classwork.task01;

public class MainApp {
    public static void main(String[] args) {
        CircleMethod circleMethod = new CircleMethod();
        System.out.println(circleMethod.getValue(1, 2, 3, (a, b, c) -> a + b + c));

    }
}
