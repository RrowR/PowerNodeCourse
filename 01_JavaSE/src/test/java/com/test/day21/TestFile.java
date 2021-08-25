package com.test.day21;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {
    @Test
    public void Test01() throws IOException {
        File file = new File("src\\test\\java\\com\\test\\day21\\b\\a.txt");
        FileOutputStream fos = new FileOutputStream(file);
        // src\test\java\com\test\day21\b\a.txt (系统找不到指定的路径。) 如果指定文件路径的文件夹路劲不存在还是会报错
        fos.write("猫羽雫".getBytes());
        fos.close();
    }

    @Test
    public void Test02(){
        File file = new File("src\\test\\java\\com\\test\\day21\\a.txt");
        System.out.println(file.exists());
    }

    @Test
    public void Test03(){
        File file = new File("src\\test\\java\\com\\test\\day21");
        File[] files = file.listFiles((dir, name) -> new File(dir, name).getName().endsWith(".png"));
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

}
