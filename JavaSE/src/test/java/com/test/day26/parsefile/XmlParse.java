package com.test.day26.parsefile;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class XmlParse {
    public static void main(String[] args) throws DocumentException {
        // 创建dom4j的关键对象类，后续都是通过这个对象来调用方法
        SAXReader reader = new SAXReader();
        File file = new File("src/main/resources/new.xml");
//        Document document = reader.read();
        System.out.println(file);

    }
}
