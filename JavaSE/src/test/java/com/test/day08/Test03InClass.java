package com.test.day08;

import java.util.Scanner;

/**
 *  获取10个学生的成绩，然后保存在数组中，最后计算学生的总分和平均分。
 */
public class Test03InClass {
    public static void main(String[] args) {
        countSumAndAvg(10);
    }

    private static void countSumAndAvg(int a) {
        // 这里手动来定义数组的长度是为了性能优化，避免每次来判断数组长度，浪费系统性能
        int count = a;
        double[] arr = new double[count];
        double sum = 0.0;
        double avg;
        Scanner input = new Scanner(System.in);
        // 这里 arr.length 效率低，避免这种方法的使用
        for (int i = 1; i <= count; i++) {
            System.out.println("请输入第"+i+"学生成绩");
            double score = input.nextDouble();
            arr[i-1] = score;
        }
        for (double score : arr) {
            sum += score;
        }
        avg = sum / count;

        System.out.println("总分为："+sum);
        System.out.println("平均成绩为"+avg);
    }
}
