package com.test.day17.project.packaging;

import java.util.Random;

/*
    Random类
 */
public class DemoRandom {
    public static void main(String[] args) {
        Random random = new Random();
        Random random2 = new Random(22);    // 随机数种子，让指定种子随机数随机的每次数字都相同

        // 指定随机数上限【0，100）
        System.out.println(random.nextInt(100));

        for (int i = 0; i < 10; i++) {
            System.out.println(random2.nextInt(100));   // 还是范围在100以内，不包含100
        }
    }
}
