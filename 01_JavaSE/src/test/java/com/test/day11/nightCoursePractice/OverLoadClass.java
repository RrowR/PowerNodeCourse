package com.test.day11.nightCoursePractice;

/**
 * 开发一个类，应包含以下重载方法
 * 	求两个数的最小值
 * 	求三个数的最小值
 * 	求一个数组中的最小值
 */
public class OverLoadClass {
    double getMin(double a, double b) {
        if (a > b){
            return b;
        }else {
            return a;
        }
    }
    double getMin(double a,double b,double c){
        double min = 0;
        if (min > a){
            min = a;
        }
        if (min > b){
            min = b;
        }
        if (min > c){
            min = c;
        }
        return c;
    }
    double getMin(double ...a){
        double min;
        min = a[0];
        for (double v : a) {
            if (min > v){
                min = v;
            }
        }
        return min;
    }
}
