package day11;

public class CalculatorObject {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.branch = "啾啾";
        c.bill = 19980.0;
        c.getMessage();
        double addResult = c.add(123.2, 321.1);
        System.out.println(addResult);
        System.out.println(c.subtraction(321.2,123.2));

    }
}
