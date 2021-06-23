package com.test.day02;

import org.junit.jupiter.api.Test;

public class Demo04EscapeCharacter {

    @Test
    public void test06(){
        // 当和int类型做加法时,结果是一个int值
        char c = 'A';
        System.out.println(c+1);
    }

    @Test
    public void test05(){
        // 打印出一个\
        char c = '\\';
        System.out.println(c);
    }

    @Test
    public void test04(){
        //打印出单引号
        char c = '\'';
        System.out.println(""+c+"");
    }

    @Test
    public void test03(){
        //打印出分号
        char c = '\"';
        System.out.println("周恩来说:"+c+"为中华之崛起读书"+c);
    }

    @Test
    public void test02(){
        // \t      tab作用，还能对齐
        char c = '\t';
        System.out.println("九九"+c+"no win");
        System.out.println("开开"+c+"popo");
    }

    @Test
    public void test01(){
        //  \n  回车
        char c = '\n';
        System.out.println("玛卡巴卡"+c+"卡玛卡玛");
    }
}
