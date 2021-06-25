package day04;

/**
 * 位运算：
 *      >> 右移   对m右移n位，则/^n,负数除外
 *      << 左移   对m左移n位，则*^n
 *      &   与   如果是数值型，则是对二进制运算，如果是boolean类型，则是做并且运算
 *      |   或   如果是数值型，则是对二进制运算，如果是boolean类型，则是做并或运算
 *      ^   异或  如果是数值型，则是对二进制运算，如果是boolean类型，则是做异或运算
 *      >>> 无符号右移   无论是整数还是负数，高位永远补0
 *
 */
public class PositionCalculate {
    public static void main(String[] args) {
//        rightMove();
//        leftMove();
        noSymbolMove();
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
