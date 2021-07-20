package com.test.day21;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {
    @Test
    public void Test01() throws IOException {
        File file = new File("src\\test\\java\\com\\test\\day21\\a.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("猫羽雫".getBytes());
        fos.close();
    }

    @Test
    public void Test02(){
        File file = new File("src\\test\\java\\com\\test\\day21\\a.txt");
        System.out.println(file.exists());
    }
}
