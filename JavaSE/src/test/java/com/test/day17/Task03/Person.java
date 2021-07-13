package com.test.day17.Task03;

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
                // 这里面直接调用就好了，方法比比较的就是这两个对象的age属性,当为-1的时候，交换2个数，结果将是一个
                // 如果是这样的冒泡排序，那么就是倒序
                // 如果 j 是从 0 开始，那么就是普通的顺序
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
