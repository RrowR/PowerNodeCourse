package com.test.day17;

import java.util.Scanner;

// 这题代码不是关键，关键是思想，判断是不是三角形的条件是两边之和大于第三遍，并且两边之差小于第三边
// 正着写代码量非常大，而且逻辑复杂，可以反过来想，只要两边之和小于等于第三边或者两边只差大于等于第三编的其中一项即可
public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println("请输入三角形的第一条边");
        int a = input.nextInt();
        System.out.println("请输入三角形的第二条边");
        int b = input.nextInt();
        System.out.println("请输入三角形的第三条边");
        int c = input.nextInt();
        triangle.setA(a);
        triangle.setB(b);
        triangle.setC(c);
        triangle.isTriangle();

    }
}
