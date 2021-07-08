package day13;

import java.util.Arrays;

/**
 * java.lang
 *  System.arraycopy 不遵守小驼峰
 *  下面方法没有方法体，是本地方法栈(native修饰)的方法
 *  public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
 */
public class Demo01Systemarraycopy {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,2,arr2,2,3);
        System.out.println(Arrays.toString(arr2));
    }
}
