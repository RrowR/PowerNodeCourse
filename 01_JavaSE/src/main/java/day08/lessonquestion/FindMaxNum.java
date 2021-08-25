package day08.lessonquestion;

public class FindMaxNum {
    public static void main(String[] args) {
        int[] arr = {5, 12, 90, 18, 77, 76, 45, 28, 59, 72};
        System.out.println(findMax(arr));
    }

    private static int findMax(int[] arr) {
        int maxNum = 0;
        for (int i : arr) {
            if (i >= maxNum){
                maxNum = i;
            }
        }
        return maxNum;
    }
}
