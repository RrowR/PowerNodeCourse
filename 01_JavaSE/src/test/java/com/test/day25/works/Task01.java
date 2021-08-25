package com.test.day25.works;

public class Task01 {
    public static void main(String[] args) {
        /*
            1.	实现字符串和字节数组之间的相互转换。必如将字符串“北京动力节点bjpowernode”转换为字节数组，并将字节数组再转换回字符串。
         */
        String str = "北京动力节点bjpowernode";
        byte[] bytes = str.getBytes();
        System.out.println(new String(bytes));
    }
}
