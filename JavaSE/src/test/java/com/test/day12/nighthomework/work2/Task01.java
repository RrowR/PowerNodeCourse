package com.test.day12.nighthomework.work2;

public class Task01 {
    int count = 9;

    public void count1() {
        count = 10;     // 这里会更改成员变量的值
        System.out.println("count1=" + count);
    }

    public void count2() {
        System.out.println("count2=" + count);
    }

    public static void main(String[] args) {
        Task01 t = new Task01();
        t.count1();
        t.count2();
        System.out.println();
    }
}

// count1= 10
// count2= 10