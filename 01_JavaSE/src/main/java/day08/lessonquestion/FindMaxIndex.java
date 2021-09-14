package day08.lessonquestion;

/**
 * 需求：获取元素59在数组{5, 12, 90, 18, 77, 76, 45, 28, 59, 72}中的索引。
 */
public class FindMaxIndex {
    public static void main(String[] args) {
        int[] arr = {5, 12, 90, 18, 77, 76, 45, 28, 59, 72};
        int a = 59;
        System.out.println(findIndex(arr, a));

    }

    private static int findIndex(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (a == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
