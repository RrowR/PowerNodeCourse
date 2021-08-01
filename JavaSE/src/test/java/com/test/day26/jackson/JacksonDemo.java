package com.test.day26.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * jacson的核心类 ObjectMapper
 * 构造方法
 * ObjectMapper();
 * 常用方法:
 * T readValue(String,Class);  将字符串解析成java对象 [*****]
 * T readValue(URL,Class);  将url解析成java对象  [***]
 * T readValue(File,Class);  将File对象解析成java对象[***]
 * T readValue(byte [],Class);  将byte数组析成java对象[***]
 * T readValue(Reader,Class);  将字符流解析成java对象[***]
 * T readValue(InputStream,Class);  将字节流解析成java对象[***]
 * <p>
 * <p>
 * String writeValueAsString(Object )  将java对象或集合转换成json字符串 [*****]
 * <p>
 * <p>
 * json字符串转成成List集合[*****]
 * CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Student.class);
 * List<Student> mylist = mapper.readValue(jsonstr, collectionType);
 *
 * @ JsonIgnore 忽略某个属性
 * @ JsonFormat(pattern = "yyyy-MM-dd") 指定日期的格式
 */
public class JacksonDemo {
    @Test
    public void jacksonMainClass() throws JsonProcessingException {
        // 这个时jackson的核心类
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "{\"author\":\"咚咚\",\"isbn\":\"001\",\"pubTime\":\"2020-06-30\"}";
        // 使用ObjectMapper里的readValue方法，将指定对象字符串转换成指定对象,这里必须要传入一个对象类型，没有只有一个str参数的方法
        Book book = mapper.readValue(jsonStr, Book.class);
        System.out.println(book);
    }

    @Test
    public void ToObject01() throws IOException {
        /*
            将指定文件里的json字符串转换成对象
         */
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src\\main\\resources\\Book.json");
        Book book = mapper.readValue(file, Book.class);
        System.out.println(book);
    }

    @Test
    public void ToObject02() throws IOException {
        /*
            将包含对象的流转换成对象
         */
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(JacksonDemo.class.getClassLoader().getResourceAsStream("Book.json"), Book.class);
        System.out.println(book);
    }

    @Test
    public void ToObject03() throws IOException {
        /*
            将含有对象的字节数组转换成一个java对象
         */
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "{\"author\":\"咚咚\",\"isbn\":\"001\",\"pubTime\":\"2020-06-30\"}";
        Book book = mapper.readValue(jsonStr.getBytes(), Book.class);
        System.out.println(book);
    }

    @Test
    public void ToObject04() throws IOException {
        /*
            将字符流转换成对象
         */
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(new InputStreamReader(JacksonDemo.class.getClassLoader().getResourceAsStream("Book.json")), Book.class);
        System.out.println(book);
    }

    @Test
    public void ToObjectByArray() throws ParseException, JsonProcessingException {
        /*
            想要将一个包含对象的字符串数组转换成对象的时候，返回的时候需要返回一个集合才可以，此时我们需要对这个集合进行一些包装(设置)
         */
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("0001", "java", "张三", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01")));
        list.add(new Book("0002", "C++", "李四", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02")));
        list.add(new Book("0003", "pythone", "王五", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-03")));
        String jsonStringArrays = mapper.writeValueAsString(list);
        // 首先需要构造一个集合，这个集合的类型是一个List,里面的数据是Book.class类型
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Book.class);
        // 传入对象数组字符串，自定义的集合类型
        List<Book> myLists = mapper.readValue(jsonStringArrays, collectionType);
        for (Book book : myLists) {
            System.out.println(book);
        }
    }


    @Test
    public void ObjectToJsonString() throws IOException {
        /*
            将一个对象转换成json字符串
            JsonFormat(pattern = "yyyy-MM-dd") 指定日期的格式
         */
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(new InputStreamReader(JacksonDemo.class.getClassLoader().getResourceAsStream("Book.json")), Book.class);
        String jsonStr = mapper.writeValueAsString(book);
        System.out.println(jsonStr);
    }

    @Test
    public void ObjectArrayToJsonString() throws ParseException, JsonProcessingException {
        /*
            将含有对象的数组转换成一个json字符串
            String writeValueAsString(Object value) 这里的参数时一个Object，可以是任意引用数据类型
         */
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("0001", "java", "张三", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01")));
        list.add(new Book("0002", "C++", "李四", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-02")));
        list.add(new Book("0003", "pythone", "王五", new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-03")));
        String jsonArrayString = mapper.writeValueAsString(list);
        System.out.println(jsonArrayString);
    }

    @Test
    public void toJsonString() throws JsonProcessingException {
        /*
            jackson将int数组，字节数组等等都可以转换成一个字符串，由于是一个数组，最外层肯定是一个[]
         */
        ObjectMapper mapper = new ObjectMapper();
        int[] ints = {1, 2, 3, 4, 5};
        String jsonString = mapper.writeValueAsString(ints);
        System.out.println(jsonString);
        System.out.println("=============分割线==============");
        Byte[] bytes = new Byte[]{97,98,99};
        String byteValues = mapper.writeValueAsString(bytes);
        System.out.println(byteValues);
    }


}
