package com.test.day08;

import org.junit.jupiter.api.Test;

/**
 * 堆和栈的测试题目
 */
public class Test04StackAndHeap {
    @Test
    public void test01(){
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr1 = null;
        System.out.println(arr1[2]); // 输出结果为？？？报错
        System.out.println(arr2[2]); // 输出结果为？？？3
    }

    @Test
    public void test02(){
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = arr1;
        arr2[2] = 33;
        System.out.println(arr1[2]); // 输出结果为？？？33
    }
}
