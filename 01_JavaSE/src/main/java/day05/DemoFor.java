package day05;

/**
 * 循环案例
 */
public class DemoFor {
    public static void main(String[] args) {
        int i = 0;
        for (System.out.print("A"); i < 3; System.out.print("B")) {
            System.out.print("C");
            i++;
        }
    }
}
