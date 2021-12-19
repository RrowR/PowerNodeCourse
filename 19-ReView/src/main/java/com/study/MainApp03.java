package com.study;


import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class MainApp03 {
    @Test
    public void test01() {
        int[] arr = {1, 4, 2, 7, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void nine2nine() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void distinctList(){
        List<Integer> list = List.of(1, 1, 3, 3, 5);
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set);
    }


}
