package com.test.day17.project.packaging;

public class PackegeClassBoolean {
    public static void main(String[] args) {
        // 构造方法可以传入boolean值
        Boolean b = new Boolean(true);
        // 也可以传入字符串
        Boolean b2 = new Boolean("true");
        System.out.println(b);
        System.out.println(b2);
    }
}
