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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Double.compare(book.price, price) == 0 &&
                    no == book.no &&
                    Objects.equals(name, book.name) &&
                    Objects.equals(publish, book.publish);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, no, publish);
        }
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
        TreeSet<Book> treeSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return ((int)(o1.no - o2.no));
            }
        });
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
            1)	使用构造方法Student(int id,String name,int age,String sex )创建多个学生信息并加入List
            2)	遍历List，输出每个Student信息
            3)	将List中数据放入Map，使用Student的id属性作为key，使用Student对象信息作为value
            4)	遍历Map，输出每个Entry的key和value
            功能2：定义方法public void mapToList( ){ }将Map中Student映射信息封装到List
            1)	创建实体类StudentEntry，可以存储Map中每个Entry的信息
            2)	使用构造方法Student(int id,String name,int age,String sex )创建多个学生信息，并使用Student的id属性作为key，存入Map
            3)	创建List对象，每个元素类型是StudentEntry
            4)	将Map中每个Entry信息放入List对象
         */
        listToMap();

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

    private void listToMap(ArrayList<E> list) {

    }

}
