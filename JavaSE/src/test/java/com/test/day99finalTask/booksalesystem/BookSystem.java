package com.test.day99finalTask.booksalesystem;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class BookSystem {
    public void start() throws DocumentException {
        InputStream bookXmlStream = BookSystem.class.getClassLoader().getResourceAsStream("book.xml");
        InputStream userAccountStream = BookSystem.class.getClassLoader().getResourceAsStream("user.xml");
        SAXReader saxReader = new SAXReader();
        Document bookDocument = saxReader.read(bookXmlStream);
        Element bookDocumentRootElement = bookDocument.getRootElement();
        Document userDocument = saxReader.read(userAccountStream);
        Element userDocumentRootElement = userDocument.getRootElement();
        ArrayList<String> bookArrays = new ArrayList<>();
        ArrayList<String> userArrays = new ArrayList<>();
        bookArrays = getAllElementText(bookArrays, bookDocumentRootElement);
        userArrays = getAllElementText(userArrays,userDocumentRootElement);
        bookArrays.forEach(System.out::println);
        userArrays.forEach(System.out::println);

    }

    public ArrayList<String> getAllElementText(ArrayList<String> list,Element element){
//        List<Element> elements = element.elements();
//        for (Element e : elements) {
//            if (e.elements() == null){
//                list.add(e.getTextTrim());
//            }else {
//                list.add(e.getTextTrim());
//                getAllElementText(list,e);
//            }
//        }
//        return list;
        Iterator<Element> iterator = element.elementIterator();
        while (iterator.hasNext()){
            Element e = iterator.next();
            Iterator<Element> e2 = e.elementIterator();
            while (e2.hasNext()){
                e2.next().getTextTrim();
            }
        }
        return null;
    }
}
