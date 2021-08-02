package com.test.day99finalTask.booksalesystem;

import com.test.day99finalTask.booksalesystem.entity.Book;
import com.test.day99finalTask.booksalesystem.entity.User;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookSystem {
    public void start() {
        try {
            InputStream bookXmlStream = BookSystem.class.getClassLoader().getResourceAsStream("book.xml");
            InputStream userAccountStream = BookSystem.class.getClassLoader().getResourceAsStream("user.xml");
            SAXReader saxReader = new SAXReader();
            Document bookDocument = saxReader.read(bookXmlStream);
            Element bookDocumentRootElement = bookDocument.getRootElement();
            Document userDocument = saxReader.read(userAccountStream);
            Element userDocumentRootElement = userDocument.getRootElement();
            StringBuilder builder = new StringBuilder();
            StringBuilder builder1 = new StringBuilder();
            StringBuilder elementText = getAllElementText(builder, bookDocumentRootElement);
            StringBuilder stringBuilder = getAllElementText(builder1, userDocumentRootElement);
            String bookArrayStr = elementText.toString().substring(0, elementText.toString().length() - 1);
            String userStr = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
            String[] userSplit = userStr.split(",");
            // 这个对象保存了账号和密码
            User user = new User();
            user.setUsername(userSplit[0]);
            user.setPassword(userSplit[1]);
            // 这个treeMap保存了xml文件里的book对象
            TreeMap<String, Book> stringBookTreeMap = new TreeMap<>((o1, o2) -> Integer.parseInt(o1) > Integer.parseInt(o2) ? 1 : -1);
            addBookMethod(stringBookTreeMap,bookArrayStr);
            Scanner input = new Scanner(System.in);
            while (true){
                System.out.println("欢迎来到图书售卖商店");
                System.out.print("请输入用户名:   ");
                String username = input.next();
                System.out.print("请输入密码:   ");
                String password = input.next();
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    System.out.println("登陆成功");
                    System.out.println("***********欢迎来到库存管理系统**************");
                    System.out.println("书号\t\t书名\t\t作者\t\t发布日期\t\t价格\t\t库存");
                    findAll(stringBookTreeMap);
                    System.out.println("请选择进行的操作:1.图书入库 2.图书出库 3.查询全部图书 4.新增图书 5.退出");
                    int select = input.nextInt();
                    switch (select){
                        case 1:
                            Book book = new Book();

                            break;
                        case 2:
                            break;
                        case 3:
                            findAll(stringBookTreeMap);
                            break;
                        case 4:
                            break;
                        case 5:
                            return;
                    }
                }else {
                    System.out.println("用户名或者密码错误，请重新输入");
                    break;
                }

            }





        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findAll(TreeMap<String, Book> stringBookTreeMap) {
        for (Map.Entry<String, Book> stringBookEntry : stringBookTreeMap.entrySet()) {
            Book book = stringBookEntry.getValue();
            System.out.println("\t" + stringBookEntry.getKey() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t" + new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishTime()) + "\t\t" + book.getPrice() + "\t\t" + book.getNum());
        }
    }

    private void addBookMethod(TreeMap<String, Book> bookMap, String bookArrayStr) throws ParseException {
        String[] bookSplit = bookArrayStr.split(",");
        int i = 0;
        while (i != bookSplit.length){
            Book book = new Book();
            outer : for (; i < bookSplit.length; i++) {
                switch (i % 6){
                    case 0:
                        book.setBookId(bookSplit[i]);
                        break;
                    case 1:
                        book.setBookName(bookSplit[i]);
                        break;
                    case 2:
                        book.setAuthor(bookSplit[i]);
                        break;
                    case 3:
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bookSplit[i]);
                        book.setPublishTime(date);
                        break;
                    case 4:
                        book.setPrice(Double.parseDouble(bookSplit[i]));
                        break;
                    case 5:
                        book.setNum(Integer.parseInt(bookSplit[i]));
                        break outer;
                }
            }
            bookMap.put(book.getBookId(),book);
            i++;
        }
    }

    public StringBuilder getAllElementText(StringBuilder builder, Element element) {
        List<Element> elements = element.elements();
        for (Element e : elements) {
            if (e.elements() != null) {
                if (e.getTextTrim().length() != 0) {
                    builder.append(e.getTextTrim() + ",");
                }
                getAllElementText(builder, e);
            }
        }
        return builder;
    }
}
