package com.test.day20;

import com.test.day19.Student;
import day14.com.study.B;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;

public class HomeWork {
    @Test
    public void Task01() {
        /*
            1.	使用List和Map存放多个图书信息，遍历并输出。其中商品属性：编号，名称，单价，出版社；使用商品编号作为Map中的key。
         */
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("java", 222.2, 123, "东方出版社"));
        list.add(new Book("C++", 222.2, 123, "东方出版社"));
        list.add(new Book("python", 222.2, 123, "东方出版社"));
        list.add(new Book("C#", 222.2, 123, "东方出版社"));
        for (Book book : list) {
            System.out.println(book);
        }
        HashMap<String, Book> map = new HashMap<>();
        map.put("1", new Book("java", 222.2, 123, "东方出版社"));
        map.put("2", new Book("C++", 222.2, 123, "东方出版社"));
        map.put("3", new Book("python", 222.2, 123, "东方出版社"));
        map.put("4", new Book("C#", 222.2, 123, "东方出版社"));
        Set<Map.Entry<String, Book>> entries = map.entrySet();
        for (Map.Entry<String, Book> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Book {
        private String name;
        private double price;
        private long no;
        private String publish;
    }

    @Test
    public void Task02() {
/*
2.	使用HashSet和TreeSet存储多个商品信息，遍历并输出；其中商品属性：编号，名称，单价，出版社；要求向其中添加多个相同的商品，验证集合中元素的唯一性。
提示：向HashSet中添加自定义类的对象信息，需要重写hashCode和equals( )
向TreeSet中添加自定义类的对象信息，需要实现Comparable接口，指定比较规则
*/
        HashSet<Book> hashSet = new HashSet<>();
        hashSet.add(new Book("java", 222.2, 124, "东方出版社"));
        hashSet.add(new Book("java", 222.2, 127, "北京出版社"));
        hashSet.add(new Book("java", 222.2, 126, "明日出版社"));
        hashSet.add(new Book("java", 222.2, 125, "南山出版社"));
        Iterator<Book> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=====================分割线========================");
        TreeSet<Book> treeSet = new TreeSet<>(((o1, o2) -> (int) (o1.getNo() - o2.getNo())));
        treeSet.add(new Book("java", 222.2, 124, "东方出版社"));
        treeSet.add(new Book("C++", 222.2, 127, "北京出版社"));
        treeSet.add(new Book("C#", 222.2, 126, "明日出版社"));
        treeSet.add(new Book("python", 222.2, 125, "南山出版社"));
        for (Book book : treeSet) {
            System.out.println(book);
        }
    }

    @Test
    public void Task03(){
        /*
            3.	实现List和Map数据的转换。具体要求如下：
            功能1：定义方法public void listToMap( ){ }将List中Student元素封装到Map中
            1)	使用构造方法Student(int id,String name,int age,String sex)创建多个学生信息并加入List
            2)	遍历List，输出每个Student信息
            3)	将List中数据放入Map，使用Student的id属性作为key，使用Student对象信息作为value
            4)	遍历Map，输出每个Entry的key和value
            功能2：定义方法public void mapToList( ){ }将Map中Student映射信息封装到List
            1)	创建实体类StudentEntry，可以存储Map中每个Entry的信息
            2)	使用构造方法Student(int id,String name,int age,String sex )创建多个学生信息，并使用Student的id属性作为key，存入Map
            3)	创建List对象，每个元素类型是StudentEntry
            4)	将Map中每个Entry信息放入List对象
         */
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1,"镜华",12,"女"));
        list.add(new Student(2,"美美",10,"女"));
        list.add(new Student(3,"猫羽雫",16,"女"));
        HashMap<Integer, Student> map = listToMap(list);
        Set<Map.Entry<Integer, Student>> entries = map.entrySet();
        for (Map.Entry<Integer, Student> entry : entries) {
            System.out.println("id为："+entry.getKey()+"属性是："+entry.getValue());
        }
        System.out.println("=====================分割线========================");
        HashMap<Integer, Student> hashMap = new HashMap<>();
        Student s1 = new Student(1, "镜华", 12, "女");
        Student s2 = new Student(2, "美美", 10, "女");
        Student s3 = new Student(3, "猫羽雫", 16, "女");
        hashMap.put(s1.getId(),s1);
        hashMap.put(s2.getId(),s2);
        hashMap.put(s3.getId(),s3);
        ArrayList<StudentEntry> studentEntryArrayList = mapToList(hashMap);
        for (StudentEntry studentEntry : studentEntryArrayList) {
            System.out.println(studentEntry.getEntry().getKey()+":"+studentEntry.getEntry().getValue());
        }

    }

    private ArrayList<StudentEntry> mapToList(HashMap<Integer, Student> hashMap) {
        Set<Map.Entry<Integer, Student>> entries = hashMap.entrySet();
        ArrayList<StudentEntry> list = new ArrayList<>();
        for (Map.Entry<Integer, Student> entry : entries) {
            list.add(new StudentEntry(entry));
        }
        return list;
    }

    class StudentEntry{
        Map.Entry entry;

        public Map.Entry getEntry() {
            return entry;
        }

        public void setEntry(Map.Entry entry) {
            this.entry = entry;
        }

        public StudentEntry(Map.Entry entry) {
            this.entry = entry;
        }
    }

    private HashMap<Integer,Student> listToMap(ArrayList<Student> list) {
        HashMap<Integer, Student> hashMap = new HashMap<>();
        for (Student student : list) {
            hashMap.put(student.getId(),student);
        }
        return hashMap;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Student{
        private int id;
        private String name;
        private int age;
        private String sex;
    }


}
