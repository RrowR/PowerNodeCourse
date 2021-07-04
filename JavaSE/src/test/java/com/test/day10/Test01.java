package com.test.day10;

import org.junit.jupiter.api.Test;

public class Test01 {
    @Test
    public void method01(){
        int[][] array = {{1,2,3},{4,5}};
        int len = array[1].length;
        System.out.println(len);
        int a[] = {1,2,3,4};
        /*
            Array initializer is not allowed here 下面这样写错误
         */
        int c[];
        // c = {1,2,34,4};

        // 这样写才正确
        int d[];
        d = new int[]{1,2,3,4};
        int[] arr = new int[5];
        // 可变参数可以传入数组
        variable(arr);

        int[][] t={{1,2,3},{4,5,6}};
        System.out.println(t.length);
    }

    public static void variable(int ...a){

    }
}
