package com.test.day04;


import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个int");
        int i = scanner.nextInt();
        System.out.println(i);
        System.out.println("请输入一个String值");
        String next = scanner.next();
        System.out.println(next);
    }
}
