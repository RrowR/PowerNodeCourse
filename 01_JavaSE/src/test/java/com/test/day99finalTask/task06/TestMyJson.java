package com.test.day99finalTask.task06;

import java.text.ParseException;
import java.util.Date;

public class TestMyJson {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ParseException {
        Person person = new Person(001, "张三", 23, new Date());
        String jsonString = MyJsonUtils.toJsonString(person);
    }
}
