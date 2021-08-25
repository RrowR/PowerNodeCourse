package day04;

/**
 * 位运算：
 *      >> 右移   对m右移n位，则/^n,负数除外
 *      << 左移   对m左移n位，则*^n
 *      >>> 无符号右移   无论是整数还是负数，高位永远补0
 *      &   与   如果是数值型，则是对二进制运算，如果是boolean类型，则是做并且运算
 *      |   或   如果是数值型，则是对二进制运算，如果是boolean类型，则是做并或运算
 *      ^   异或  如果是数值型，则是对二进制运算，如果是boolean类型，则是做异或运算
 *      ~ 非位运算
 */
public class PositionCalculate {
    public static void main(String[] args) {
//        rightMove();
//        leftMove();
//        noSymbolMove();
//        AndMove();
//        OrMove();
//        DiffOr();
//        NoPositionCalculate();
        ExchangeTwoNumbers();
    }

    private static void ExchangeTwoNumbers() {
        /**
         *
         * 使用异或运算来交换2个数
         */
        int a = 3,b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a="+a+",b="+b);
    }

    private static void NoPositionCalculate() {
        /**
         * 二进制位取反
         *      0001
         *      1110     //取反
         *      0001     //负数取反
         * 100..0010     //+1
         */
        int a = ~1;
        System.out.println(a);
    }

    private static void DiffOr() {
        /**
         * 不同位1
         * 0011
         * 0101
         * 0110
         */
        int a = 3 ^ 5;
        System.out.println(a);
    }

    private static void OrMove() {
        /**
         * 只要有一个是1就是1
         * 0010
         * 0101
         * 0111
         */
        int a = 2;
        int b = 5;
        int c = a | b;
        System.out.println(c);
    }

    private static void AndMove() {
        //与运算
        /**
         *      0011
         *      0101
         *      0001
         */
        int a = 3;
        int b = 5;
        int c = a & b;
        System.out.println(c);
    }

    private static void noSymbolMove() {
        //无符号右移一位
        int a = 4 >>> 1;
        int b = -4 >>> 1;
        System.out.println(a);
        System.out.println(b);
    }

    private static void leftMove() {
        //左移一位
        int a = 4 << 1;
        int b = -4 << 1;
        System.out.println(a);      //8
        System.out.println(b);
    }

    private static void rightMove() {
        //右移一位/2
        int a = 4 >> 1;
        int b = -4 >> 1;
        System.out.println(a);      //2
        System.out.println(b);
    }
}
