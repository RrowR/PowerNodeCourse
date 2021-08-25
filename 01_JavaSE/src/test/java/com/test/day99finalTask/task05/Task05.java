package com.test.day99finalTask.task05;

/**
 * 写一个JSON工具类可以把对象转成JSON对象
 * 写一个JSON工具类可以把对象转成JSON对象并可以改属性名
 */
public class Task05 {
    public static void main(String[] args) {
        Person p1 = new Person("镜华", 12);
        String jsonString = JsonUtils.toJsonString(p1);
        System.out.println(jsonString);
    }
}
