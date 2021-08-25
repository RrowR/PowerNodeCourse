package com.test.day18.test;

public class TestStringBuffer {
    public static void main(String args[]) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        mb_operate(a, b);
        System.out.println(a + "." + b);
    }
    static void mb_operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}

