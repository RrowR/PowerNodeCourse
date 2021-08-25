package day09;

import java.util.Arrays;
import java.util.Collections;

public class ClassIssue {
    public static void main(String[] args) {
        int[] arr = {5,12,90,18,77,76};
        method01(arr);
        method02(arr);

    }

    private static void method02(int[] arr) {
        /**
         * 首尾交换，节约了时间和空间
         */
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];
        }
        Arrays.toString(arr);

    }

    private static void method01(int[] arr) {
        /**
         * 中途定义了一个新数组，浪费了空间
         * 遍历了全部，浪费了时间
         */
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr.length - 1 - i] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));
    }
}
