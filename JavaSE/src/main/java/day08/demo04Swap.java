package day08;

/**
 * 基本数据类型交换2个元素，是在栈内存中进行交换
 */
public class demo04Swap {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        methodSwap(a,b);
        System.out.println("a="+a+"b="+b);
    }

    private static void methodSwap(int a,int b) {
        int temp  = a;
        a = b;
        b = temp;
        System.out.println("a="+a+"b="+b);

    }
}
