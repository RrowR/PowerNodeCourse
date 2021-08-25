package com.test.day25.works;

import java.io.*;
import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
            2.	实现字节数组和任何基本类型和引用类型执行的相互转换
            提示：使用ByteArrayInutStream和ByteArrayOutputStream。
         */
        // 内存流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 将内存流包装到对象流里去
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // 将一个包装类封装成一个对象，通过ObjectOutputStream将对象写入到内存流ByteArrayOutputStream中
        // 这里是 ObjectOutputStream 实现过来的方法
        oos.writeInt(123);
        oos.writeBoolean(true);
        oos.writeObject(new Person("镜华",12));
        bos.close();
        oos.close();

        // 将内存流中的对象转换成一个字节数组(里面包含 int、boolean、Person)
        byte[] bytes = bos.toByteArray();

        // new ByteArrayInputStream(bytes) 使用内存读取流读取包含对象的字节数组
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readObject());
        ois.close();

    }
}
