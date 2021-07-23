package day23.afternoon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class WriterObjectPackage {
    public static void main(String[] args) throws IOException, ParseException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // 将book对象保存到内存中
        oos.writeObject(new Book("java",new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-24")));
        // 读取内存流 ByteArrayOutputStream 存储的对象内容（字节数组）
        byte[] bytes = bos.toByteArray();
        System.out.println(Arrays.toString(bytes));

    }
}
