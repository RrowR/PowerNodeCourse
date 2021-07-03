package day10;

import java.util.Arrays;

/**
 * 需求：在数组{5, 12, 90, 18, 77, 76, 45, 28, 59, 72} 索引为2的位置插入元素222，插入后：{5, 12, 222, 90, 18, 77, 76, 45, 28, 59, 72}。
 */
public class Demo02InsertArrays {
    public static void main(String[] args) {
        int[] arr = {5, 12, 90, 18, 77, 76, 45, 28, 59, 72};
        int index = 2;
        int value = 222;
        arr = insert(arr, index, value);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] insert(int[] arr, int index, int value) {

        if (arr.length == 10){
            int[] newArr = new int[arr.length + 1];
            // 创建新的数组长度+1
            // 将旧数组拷贝到新数组中来
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            // 从后往前遍历
            for (int i = newArr.length - 1; i > index; i--) {
                newArr[i] = newArr[i-1];
            }
            // 将2置为index的内容
            newArr[index] = value;

            // 最后一步很重要，要将原数组的指向改变成新数组
            arr = newArr;
        }
        return arr;
    }
}
