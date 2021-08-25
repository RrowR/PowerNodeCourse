package com.test.day10;

import java.util.Arrays;

/**
 * 数组逆序操作：定义长度为10的数组，将数组元素对调，并输出对调前后的结果。
 * 思路：把0索引和arr.length-1的元素交换，把1索引和arr.length-2的元素交换
 * 只要交换到arr.length/2的时候即可。
 */
public class Question3 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[arr.length - 1 - i] + arr[i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
