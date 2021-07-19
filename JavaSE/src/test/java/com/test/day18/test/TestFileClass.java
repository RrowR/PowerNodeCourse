package com.test.day18.test;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class TestFileClass {
    @Test
    public void Test01(){
        File file = new File("JavaSE/src");
        System.out.println(file.exists());
    }

    @Test
    public void Test02(){
        int i = Integer.parseInt("123");
    }

    @Test
    public void Test03(){
        String str="abcedf";
        int len = str.length();
        System.out.println(len);
    }

    @Test
    public void Test04(){
        Date date = new Date();
        System.out.println(date);
    }
}
