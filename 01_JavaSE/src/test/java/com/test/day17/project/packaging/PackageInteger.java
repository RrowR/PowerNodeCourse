package com.test.day17.project.packaging;

public class PackageInteger {
    public static void main(String[] args) {
        Integer integer = new Integer(200);
        System.out.println(integer);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 将Integer类型转换成其他类型,此方法并不是一个静态方法
        float f = integer.floatValue();
        double d = integer.doubleValue();
        int i = integer.intValue();
        byte b = integer.byteValue();


    }
}
