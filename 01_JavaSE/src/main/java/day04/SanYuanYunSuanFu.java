package day04;

/**
 * 三元运算符，可以简化if else庸余代码
 */
public class SanYuanYunSuanFu {
    public static void main(String[] args) {
        selectMax(2,5);
    }

    private static void selectMax(int a,int b) {
        int max = a > b ? a : b;
        System.out.println("最大值max="+max);
    }
}
