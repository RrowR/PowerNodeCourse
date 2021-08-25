package day23.afternoon;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(new Book("java",new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-12")));
        arrayList.add(new Book("C++",new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-12")));
        arrayList.add(new Book("C#",new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-12")));
        System.out.println(arrayList);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // 将含有对象的ArrayList写入到 ByteArrayOutputStream (字节数组输出流中),此时 ByteArrayOutputStream 含有了这个ArrayList对象
        oos.writeObject(arrayList);

        // 将 ByteArrayOutputStream 中的ArrayList转换成一个一个的字节数组
        byte[] bytes = bos.toByteArray();
        System.out.println(Arrays.toString(bytes));

        // 将 ByteArrayOutputStream 中获得的字节数组传到 ByteArrayInputStream 中
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object o = ois.readObject();
        System.out.println((ArrayList<Book>) o);        // 这里不强转都可以成功显示
//        System.out.println(o);
        System.out.println(o == arrayList);     // 此时的2个集合已经不同了，虽然内容一样，老师这是对象的clone

    }
}
