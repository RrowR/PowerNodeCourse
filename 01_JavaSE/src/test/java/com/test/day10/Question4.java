package com.test.day10;

/**
 *  二维数组遍历求和操作：用二重循环求出二维数组b所有元素的和：
 *  int[][] b={{11},{21,22},{31,32,33}}
 */
public class Question4 {
    public static void main(String[] args) {
        int results = 0;
        int[][] b = {{11},{21,22},{31,32,33}};
        for (int i = 0; i < b.length; i++) {
            for (int result : b[i]) {
                results += result;
            }
        }
        System.out.println(results);
    }
}
