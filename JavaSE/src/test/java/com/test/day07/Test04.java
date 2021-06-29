package com.test.day07;

/**
 * 	输入三个班，每班10个学生的成绩，求和并求平均分
 */
public class Test04 {
    public static void main(String[] args) {
        numberClassScore(3);
    }

    public static void numberClassScore(int number){
        int score = 0;
        int count = 0;
        int sumScore = 0;
        for (int i = 1; i <= number ; i++) {
            for (int j = 1; j <= 10 ; j++) {
                score = (int)(Math.random() * 100 + 1);
                System.out.println(i+"班"+"的"+j+"号学生"+"的成绩为："+score);
                sumScore += score;
                count++;
            }
        }
        System.out.print("平均成绩为："+ sumScore / count);
    }
}
