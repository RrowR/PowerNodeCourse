package com.test.day26.parsefile;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XmlParsePraictice {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(XmlParsePraictice.class.getClassLoader().getResourceAsStream("dom4jForStudy.xml"));
        Element rootElement = document.getRootElement();
        /*
            System.out.println(rootElement.getName());         // Person  这里的根是Person而非 <?xml version="1.0" encoding="UTF-8" ?>
        */

        List<Element> elements = rootElement.elements();
        Element element = elements.get(0);

        // 获取标签的内容的3个方法
        System.out.println(element.getStringValue());
        System.out.println(element.getTextTrim());
        System.out.println(element.getText());
        System.out.println("获取element的内容");
        // 获取标签的属性
        System.out.println(element.attribute(0).getName() + " " + element.attribute(0).getValue());
        System.out.println(element.attribute(1).getName() + " " + element.attribute(1).getValue());
        System.out.println(element.attribute(2).getName() + " " + element.attribute(2).getValue());
        System.out.println(element.attribute("id").getName());
        System.out.println(element.attribute("value").getValue());
        System.out.println(element.attribute("school").getValue());
        List<String> list = element.attributes();
        System.out.println("===============================第二个element2=====================================");
        Element element2 = elements.get(1);
        System.out.println(element2.getText());
        List<Element> element22 = element2.elements();
        Element element21 = element22.get(0);
        System.out.println("==============================Person下的第二个Student的第一个element========================");
        System.out.println(element21.attribute(0).getName());
        System.out.println(element21.attribute(0).getValue());
        System.out.println(element21.attribute(1).getName());
        System.out.println(element21.attribute(1).getValue());
        System.out.println(element21.getTextTrim());
        System.out.println("==============================Person下的第三个Student的第一个element========================");
        Element element222 = element22.get(1);
        System.out.println(element222.attribute(0).getName());
        System.out.println(element222.attribute(0).getValue());
        System.out.println(element222.getTextTrim());
        System.out.println("=================================上面是第一个StudentElement==========================================");
        List<Attribute> attributes = element222.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName());
            System.out.println(element222.attributeValue(attribute.getName()));
        }

    }
}
