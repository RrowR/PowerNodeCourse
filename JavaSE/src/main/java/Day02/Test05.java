package Day02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 加密练习
 * 4.	某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。结果如图所示。
 */
public class Test05 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("请输入一个4位正整数");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int i = Integer.parseInt(next);
        list.add((i / 1000) % 10);
        list.add((i / 100) % 10);
        list.add((i / 10) % 10);
        list.add(i % 10);
        list.set(0, (list.get(0) + 5) % 10);
        list.set(1, (list.get(1) + 5) % 10);
        list.set(2, (list.get(2) + 5) % 10);
        list.set(3, (list.get(3) + 5) % 10);
        int temp = 0;
        temp = list.get(0);
        list.set(0, list.get(3));
        list.set(3, temp);
        temp = list.get(1);
        list.set(1, list.get(2));
        list.set(2, temp);
        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}
