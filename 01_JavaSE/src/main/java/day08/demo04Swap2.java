package day08;

public class demo04Swap2 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        swapToArray(arr);
        System.out.println("第一个值为" + arr[0] + "第二个值为" + arr[1]);
    }

    public static void swapToArray(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.println("第一个值为"+arr[0]+"第二个值为"+arr[1]);
    }
}
