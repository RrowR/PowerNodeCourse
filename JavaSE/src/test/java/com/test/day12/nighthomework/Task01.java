package com.test.day12.nighthomework;

public class Task01 {
    public static void main(String[] args) {
        int[] arrA = {12, 22, 8, 49, 3};
        int k = 0;
        int len = arrA.length;      // 5
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arrA[i] > arrA[j]) {
                    k = arrA[i];
                    arrA[i] = arrA[j];
                    arrA[j] = k;
                }
            }
        }
        for (int i = 0; i < arrA.length; i++) {
            System.out.print(arrA[i]);
            if (i < arrA.length - 1) {
                System.out.print("，");
            }
        }
    }
}
