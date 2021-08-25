package day08;

public class demo02Array {
    public static void main(String[] args) {
        method01();
//        method02();
//        method03();
    }

    private static void method03() {
        int[] arr = new int[10];
        System.out.println(arr[0]);
        double[] arr2 = new double[10];
        System.out.println(arr2[0]);
        boolean[] arr3 = new boolean[5];
        System.out.println(arr3[0]);
        char[] arr4 = new char[5];
        System.out.println(arr4[0]);            // 默认值为 ： 空格 \u0000
        String[] arr5 = new String[5];
        System.out.println(arr5[0]);               // null
    }

    private static void method02() {
        int[] arr = new int[10];
        System.out.println(arr.length);
    }

    private static void method01() {
        long start = System.currentTimeMillis();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            System.out.println(num);
        }
        long end = System.currentTimeMillis();
    }
}
