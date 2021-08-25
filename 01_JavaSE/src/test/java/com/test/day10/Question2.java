package com.test.day10;

/**
 * 获取数组最大值和最小值操作：利用Java的Math类的random()方法，编写函数得到0到n之间的随机数，n是参数。并找出产生50个这样的随机数中最大的、最小的数，并统计其中>=60的有多少个。
 * 提示：使用 int num=(int)(n*Math.random());获取随机数
 */
public class Question2 {
    public static void main(String[] args) {
        methodRandomNumbers(100);
    }
    public static void methodRandomNumbers(int n){
        int[] arr = new int[n];
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            double random = Math.random();
            int r = (int)(random * 101);
            arr[i] = r;
        }
        max = arr[0];
        min = arr[0];
        int count = 0;
        for (int i : arr) {
            if (i > max){
                max = i;
            }
            if (i < min){
                min = i;
            }
            if (i >= 60){
                count++;
            }
        }
        System.out.println("最大值max="+max+" 最小值min="+min+" 大于等于60的数有"+count+"个");
    }
}
