package com.test.day17.project.stringbuilderstringbuffer;

import org.junit.Test;

public class Demo01StringBuffer {

    /*
        将StringBuffer的内容转换为字符串
     */
    @Test
    public void SbtoString(){
        StringBuffer sb = new StringBuffer("bacdwe,qdsa");
        String s = sb.toString();
        System.out.println(s);
    }

    /*
        indexOf(String s) 返回字符串s的位置
     */
    @Test
    public void indexOf(){
        StringBuffer sb = new StringBuffer("bacdwe,qdsa");
        System.out.println(sb.indexOf(","));
    }

    /*
        指定位置插入指定字符串，插入的内容不一定是一个字符串
     */
    @Test
    public void insert(){
        StringBuffer sb = new StringBuffer("bacdweqdsa");
        sb.insert(2,"kkk");
        System.out.println(sb);
    }

    /*
        删除指定索引位置的StringBuffer里的内容
     */
    @Test
    public void delete(){
        // 使用默认的构造方法可以直接添加内容
        StringBuffer sb = new StringBuffer("bacdweqdsa");
        sb.delete(1,3);
        System.out.println(sb);
    }

    /*
        使用StringBuffer append字符串速度非常快
     */
    @Test
    public void StringBufferappend(){
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sb.append("i");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
