package com.test.day10;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

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

    @Test
    public void test02(){
        int i = (int) ((Math.random() * 33) + 1);
        System.out.println(i);
    }

    @Test
    public void test03(){
        HashSet<String> set = new HashSet<>();
        String[] arr = {"a","b","c","d","e"};
        for (String s : arr) {
            set.add(s);
            if (set.size() == 3){
                break;
            }
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
