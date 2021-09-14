package com.test.day16.Task03;

public class Person implements Comparable{
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (age > ((Person) o).age){
            return 1;
        }else if (age < ((Person) o).age){
            return -1;
        }else {
            return 0;
        }
    }

    public void sortArr(Object arr[]){
        Object o = null;
        // 排序前
        for (Object o1 : arr) {
            String name = ((Person) o1).name;
            int age = ((Person) o1).age;
            System.out.println("name="+name+",age="+age);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // 我这里使用的是选择排序，而不是冒泡排序
                if (((Person)arr[i]).compareTo(((Person)arr[j])) == -1){
                    o = arr[i];
                    arr[i] = arr[j];
                    arr[j] = o;
                }
            }
        }
        System.out.println("=================分割线======================");
        // 排序后
        for (Object o1 : arr) {
            String name = ((Person) o1).name;
            int age = ((Person) o1).age;
            System.out.println("name="+name+",age="+age);
        }
    }
}
