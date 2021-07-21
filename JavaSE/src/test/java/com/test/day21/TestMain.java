package com.test.day21;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class TestMain {
    @Test
    public void IOmethod(){
        /*
            1. 在E:mydoc中全盘查找最近7天修改过的world文档
         */
        File file = new File("E:mydoc");
        File[] files = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        ArrayList<File> list = findWord(files,arrayList);
        /*
            long lastModified() 返回此抽象路径名表示的文件最后一次被修改的时间。
         */
        for (File f : list) {
            long lastModified = f.lastModified();
            if ((System.currentTimeMillis() - lastModified) < 0.1 * 24 * 60 * 60 * 1000){
                System.out.println(f);
            }
        }

    }

    @Test
    public void Task02(){
        /*
            java.lang.Object
                继承者 java.io.InputStream

                public abstract class InputStream extends Object implements Closeable

                java.lang.Object
                  继承者 java.io.InputStream
                      继承者 java.io.FileInputStream

                public class FileInputStream extends InputStream

                FileInputStream(File file)
                通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。
                FileInputStream(String name)
                通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。


         */
//        File file = new File("E:\\mydoc\\abc.txt");
//        FileInputStream fis = new FileInputStream("E:\\mydoc\\abc.txt");
//        FileInputStream fis = new FileInputStream(file);
//        FileInputStream fis = new FileInputStream(new File("E:\\mydoc\\abc.txt"));
        /*
        FileInputStream fis = null;
        try {
           fis = new FileInputStream(new File("E:\\mydoc\\zfb.txt"));
        *//*
        int len;
        while ((len = fis.read()) != -1){
            System.out.println(((char) len));
        }
            fis.close();
*//*
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        try(FileInputStream fis = new FileInputStream(new File("E:\\mydoc\\zfb.txt"))) {
        /*
        int len;
        while ((len = fis.read()) != -1){
            System.out.println(((char) len));
        }
            fis.close();
*/
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<File> findWord(File[] files,ArrayList<File> list){
        for (File f : files) {
            if (f.isDirectory()){
                File[] f2 = f.listFiles();
                findWord(f2,list);
            }else {
                if (f.getName().endsWith(".doc") || f.getName().endsWith(".docx")){
                    list.add(f);
                }
            }
        }
        return list;
    }
}
