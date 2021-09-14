package com.test.day12;

import java.util.Arrays;

/**
 *  java.lang.Object
 *   java.util.Arrays
 *  static boolean equals(Object[] a, Object[] a2) 如果两个指定的对象数组彼此 相等 ，则返回 true
 *  static int[] copyOf(int[] original, int newLength) 复制指定的数组，截取或用 0 填充（如有必要），以使副本具有指定的长度。
 *  sstatic <T> T[] copyOfRange(T[] original, int from, int to) 将指定数组的指定范围复制到新数组中。  
 */
public class TestArrays {
    public static void main(String[] args) {
        ArraysEquals();
        ArrayscopyOf();
        ArrayscopyOfRange();

    }

    // 使用Arrays.copyOfRange方法，复制指定起始位置到结束位置的数据到一个新的数组中，可以是任意数据类型
    private static void ArrayscopyOfRange() {
        int[] arr1 = {1,2,3,4,5};
        int[] copy = Arrays.copyOfRange(arr1, 0, 3);
        System.out.println(Arrays.toString(copy));
    }


    // 使用Arrays.copyOf方法，复制从0位置开始的长度为lenth的数据到一个新数组中
    private static void ArrayscopyOf() {
        int[] arr1 = {1,2,3,4,5};
        int[] copyOf = Arrays.copyOf(arr1, 2);
        System.out.println(Arrays.toString(copyOf));
    }

    // Arrays.equals(<T>[] a,<T>[] b) 比较的是2个数组内容是否相等
    private static void ArraysEquals() {
        int[] arr = {1,2,3};
        int[] arr2 = {1,2,3};
        boolean b = Arrays.equals(arr, arr2);
        System.out.println(b);

    }
}
