package com.test.day09;

import java.util.Scanner;

/**
 * 因式分解
 */
public class Factorization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数:");
        int num = input.nextInt();
        int oldNum = num;
        String s = num + "=";
        while (true) {
            int i = 2;
            for (; i < num; i++) {
                if (num % i == 0) {
                    s += i + "*";
                    num /= i;
                    break;
                }
            }
            if (i == num){
                s += num == oldNum ? num + "*1" : num;
                break;
            }
        }
        System.out.println(s);
    }
}
