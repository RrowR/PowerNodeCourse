package day10;

public class Demo04VariableArguments {
    public static void main(String[] args) {
        System.out.println(method(1, 2, 3, 4, 5, 6));
    }

    private static int method(int ...a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
