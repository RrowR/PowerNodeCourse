package day02;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入圆的半径");
        String next = scanner.next();
        int i = Integer.parseInt(next);
        System.out.println("该圆的半径R="+i);
        System.out.println("该圆的周长为C="+3.14*2*i);
        System.out.println("圆的面积为S="+3.14*i*i);
    }
}
