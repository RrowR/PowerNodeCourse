package com.test.day26.parsefile;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlParse {
    public static void main(String[] args) throws DocumentException {
        // 创建dom4j的关键对象类，后续都是通过这个对象来调用方法
        SAXReader reader = new SAXReader();
        // 通过反射获取到这个配置文件的字节流
        InputStream inputStream = XmlParse.class.getClassLoader().getResourceAsStream("news.xml");
        // 调用SAXReader里的read方法将配置文件的字节流传进去，其实里面是一个一个的字符
        Document read = reader.read(inputStream);
        // 获取这个xml文件的文档对象，我们就是来操作这个文档对象的
        Document document = read.getDocument();
        // 获取这个根节点的元素
        Element root = document.getRootElement();
        // 获取这个根节点下的所有子元素(注意：这里要加上泛型，否则取出来都是object)
        getAllElents(root);

    }

    private static void getAllElents(Element element) {
        List<Element> elements = element.elements();
        for (Element e : elements) {
            if (e.elements() != null){
                System.out.println(e.getTextTrim());
                getAllElents(e);
            }else {
                System.out.println(e.getName());
            }
        }
    }
}
