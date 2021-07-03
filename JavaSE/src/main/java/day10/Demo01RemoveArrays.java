package day10;

import java.util.Arrays;

/**
 * 删除数组里的其中一个内容，后面的全部需要向前移动一位(就是覆盖)
 * 然后将最后一位元素设置为默认值
 */
public class Demo01RemoveArrays {
    public static void main(String[] args) {
        int[] arr = {5,12,90,18,77,76,45,28,59,72};
        int index = 2;
        delete(arr, index);
    }

    private static void delete(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i]  = arr[i+1];
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}
