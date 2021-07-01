package com.test.day08;

public class Test01 {
    public static void main(String[] args) {
        int add = add(1, 2, 3,4,5,6,7,8,9,10);
        System.out.println(add);
    }

    // 这里的可变长度c需要遍历出来
    public static int add(int a,int b,int ... c){
        int sum = a + b;
        for (int i : c) {
            sum += i;
        }
        return sum;
    }

    public static int add(int a,int b){
        return a + b;
    }
}
