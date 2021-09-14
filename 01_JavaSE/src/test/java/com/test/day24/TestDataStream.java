package com.test.day24;

import java.io.*;

/*
    使用DataOutputStream和DataInputStream可以读取指定文件里的任意类型的引用数据类型的对象
 */
public class TestDataStream {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("JavaSE/src/b.txt"));
        dos.writeInt(213);
        dos.writeDouble(213.2321);
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("JavaSE/src/b.txt"));
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        dis.close();
    }
}
