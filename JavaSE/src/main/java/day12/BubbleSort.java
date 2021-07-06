package day12;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,7,9,13,8};
        // 比较的次数 = 索引的次数
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                    flag = false;
                }
            }
            if (flag == true){
                break;
            }
            System.out.print("第"+(i+1)+"趟排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}
