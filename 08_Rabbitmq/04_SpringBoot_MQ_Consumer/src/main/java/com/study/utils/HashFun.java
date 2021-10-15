package com.study.utils;

import org.springframework.util.StringUtils;


/*
    特征函数
 */
public class HashFun {
    private int size;
    private int seed;

    public HashFun(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    /*
            自己写一个hashcode算法
         */
    public int hash(String str) {
        int h = 0;
        if (!StringUtils.hasText(str)){
            return h;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
                h = h * seed + chars[i];
            }
        return h;
    }

    public int getPos(String str){
        int hash = hash(str);
        return hash & (size - 1);
    }

    public static void main(String[] args) {
        HashFun hashFun = new HashFun(2 << 29, 11);
        int num = hashFun.getPos("abcdwsddsadaasdadasdqwqdefg");
        System.out.println(num);
    }

}
