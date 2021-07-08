package day12;


/**
 * 二分查找:
 *      前提：必须是一个有序数组
 */
public class HalfDiliverSearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16,18};
        int serachNum = 20;
        HalfSearch(arr, serachNum);
    }

    private static void HalfSearch(int[] arr, int serachNum) {
        int min = 0;
        int max = arr.length - 1;
        while (true){
        // 这个mid应该定义在里面，否则这个mid将会一直是4
        int mid = (min + max) / 2;
            if (serachNum > arr[mid]){
                min = mid + 1;
            }else if (serachNum < arr[mid]){
                max = mid - 1;
            }else if (arr[mid] == serachNum){
                System.out.println("当前元素的索引为"+mid);
                break;
            }
            // 这里只能单独设置判断，不能整合在上面，因为和上面的判断毫无关系
            else if (max <= min){
                System.out.println("您找的数不存在");
                break;
            }
        }
    }
}
