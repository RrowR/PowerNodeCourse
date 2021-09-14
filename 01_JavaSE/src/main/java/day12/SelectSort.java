package day12;

import java.util.Arrays;

/**
 * 先择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 7, 4, 8, 9, 0, 2};
        // 外侧循环控制循环的趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内测循环从 i+1 开始 到arr.lenth - 1结束
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j] + arr[i];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
            System.out.print("第" + (i + 1) + "趟");
            System.out.println(Arrays.toString(arr));
        }
    }
}
