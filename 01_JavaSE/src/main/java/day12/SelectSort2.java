package day12;

import java.util.Arrays;

/**
 * 选择排序的优化,只替换最小索引，避免了元素之间的重复交换
 */
public class SelectSort2 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 7, 4, 8, 9, 0, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            // 使用min变量来保存最小值的索引，根据外层循环i来进行保存，随着i的递增min也会递增
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            // 当min和i的索引对应的值不相等的时候，则需要交换，也只可能不等，因为arr[min]要么比arr[i]小，要么和arr[i]相等
            if (arr[i] != arr[min]){
                arr[i] = arr[min] + arr[i];
                arr[min] = arr[i] - arr[min];
                arr[i] = arr[i] - arr[min];
            }
            System.out.print("第" + (i + 1) + "趟");
            System.out.println(Arrays.toString(arr));
        }
    }
}
