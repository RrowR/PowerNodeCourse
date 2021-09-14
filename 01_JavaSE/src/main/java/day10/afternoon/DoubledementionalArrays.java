package day10.afternoon;

/**
 * 二维数组
 */
public class DoubledementionalArrays {
    public static void main(String[] args) {
        // 声明二维数组的方式  ， 建议使用第一种
        // 方式1：静态创建
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        /*
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
        */
        // 方式1的另一种创建方式
        int[][] arr2 = {{},{}};
        // 方式2：不推荐
        int[] arr3[];

        // 动态创建等长二维数组
        int[][] arr4 = new int[3][2];

        // 创建不等长的二维数组       数组是引用数据类型
        int[][] arr5 = new int[3][];      // 创建不等长的二维数组，二维数组中的元素没有地址值，默认是null
        for (int[] i : arr5) {
            System.out.println(i);      // null
        }

        arr5[0] = new int[3];
        arr5[1] = new int[2];
        arr5[2] = new int[3];

        for (int[] i : arr5) {
            System.out.println(i);
        }


    }
}
