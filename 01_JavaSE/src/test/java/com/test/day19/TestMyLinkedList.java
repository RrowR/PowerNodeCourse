package com.test.day19;


import java.util.Iterator;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(new Student("sdsad",123));
        myLinkedList.add(new Student("222",123));
        myLinkedList.add(new Student("sdsa333d",123));
        myLinkedList.add(new Student("sds22ad",123));
        // 我这是自己定义的链表，根本就用不了增强for，连最基本的fori都不能调用，只能使用我里面定义的iterator方法
        Iterator<Student> iterator = myLinkedList.iterator();
        while (iterator.hasNext() != false){
            System.out.println(iterator.next());
        }
        System.out.println(myLinkedList.size());
    }
}
