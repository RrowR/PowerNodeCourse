package com.study.booksalesystem2;


import com.study.booksalesystem2.entity.Book;
import com.study.booksalesystem2.entity.User;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
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
            addBookMethod(stringBookTreeMap, bookArrayStr);
            ArrayList<Book> books = new ArrayList<>();
            treeMapConvertToArray(books, stringBookTreeMap);
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("欢迎来到图书售卖商店");
                System.out.print("请输入用户名:   ");
                String username = input.next();
                System.out.print("请输入密码:   ");
                String password = input.next();
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("登陆成功");
                    System.out.println("***********欢迎来到库存管理系统**************");
                    System.out.println("书号\t\t书名\t\t作者\t\t发布日期\t\t价格\t\t库存");
                    findAll(books);
                    System.out.println("请选择进行的操作:1.图书入库 2.图书出库 3.查询全部图书 4.新增图书 5.退出");
                    int select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.println("请输入ID");
                            String id = input.next();
                            System.out.println("请输入入库数量");
                            int num = input.nextInt();
                            if (insertNum(books, id, num)) {
                                findAll(books);
                                createXml(books);
                            } else {
                                findAll(books);
                                System.out.println("您的订单号不存在...");
                            }
                            break;
                        case 2:
                            System.out.println("请输入ID");
                            String id2 = input.next();
                            System.out.println("请输出库数量");
                            int num2 = input.nextInt();
                            if (decreaseselectedBooks(books, id2, num2)) {
                                findAll(books);
                                createXml(books);
                            } else {
                                findAll(books);
                                System.out.println("您的订单号不存在...");
                            }
                            break;
                        case 3:
                            findAll(books);
                            break;
                        case 4:
                            System.out.println("请输入要新增图书的id号");
                            String id4 = input.next();
                            System.out.println("请输入要新增图书的名字");
                            String name4 = input.next();
                            System.out.println("请输入图书的作者");
                            String author = input.next();
                            System.out.println("请输入图书的价格");
                            double price = input.nextDouble();
                            System.out.println("请输入图书的数量");
                            int num4 = input.nextInt();
                            Book book = new Book();
                            book.setBookId(id4);
                            book.setBookName(name4);
                            book.setAuthor(author);
                            book.setPublishTime(new Date());
                            book.setPrice(price);
                            book.setNum(num4);
                            books.add(book);
                            System.out.println("图书添加成功");
                            findAll(books);
                            createXml(books);
                            break;
                        case 5:
                            return;
                    }
                } else {
                    System.out.println("用户名或者密码错误，请重新输入");
                    continue;
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean decreaseselectedBooks(ArrayList<Book> books, String id2, int num2) {
        for (Book book : books) {
            if (book.getBookId().equals(id2)) {
                book.setNum(book.getNum() - num2);
                return true;
            }
        }
        return false;
    }

    private void createXml(ArrayList<Book> list) throws IOException {
        // 创建一个document对象
        Document document = DocumentHelper.createDocument();
        // 创建document对象的第一个节点
        Element books = document.addElement("books");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        OutputFormat format = OutputFormat.createCompactFormat();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(new FileWriter("JavaSE/src/main/resources/book2.xml"), format);
        for (Book book : list) {
            Element b = books.addElement("book");
            Element bookId = b.addElement("bookId");
            bookId.addText(book.getBookId());
            Element bookName = b.addElement("bookName");
            bookName.addText(book.getBookName());
            Element author = b.addElement("author");
            author.addText(book.getAuthor());
            Element publishTime = b.addElement("publishTime");
            publishTime.addText(sdf.format(book.getPublishTime()));
            Element price = b.addElement("price");
            price.addText(book.getPrice().toString());
            Element num = b.addElement("num");
            num.addText(book.getNum().toString());
        }
        writer.write(document);
        writer.close();
        System.out.println("创建成功");
    }

    private boolean insertNum(ArrayList<Book> books, String id, int num) {
        for (Book book : books) {
            if (book.getBookId().equals(id)) {
                book.setNum(book.getNum() + num);
                return true;
            }
        }
        return false;
    }

    private void treeMapConvertToArray(ArrayList<Book> books, TreeMap<String, Book> stringBookTreeMap) {
        Collection<Book> values = stringBookTreeMap.values();
        for (Book book : values) {
            books.add(book);
        }
    }

    private void findAll(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book.getBookId() + "\t\t" + book.getBookName() + "\t\t" + book.getAuthor() + "\t\t" + new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishTime()) + "\t\t" + book.getPrice() + "\t\t" + book.getNum());
        }
    }

    private void addBookMethod(TreeMap<String, Book> bookMap, String bookArrayStr) throws ParseException {
        String[] bookSplit = bookArrayStr.split(",");
        int i = 0;
        while (i != bookSplit.length) {
            Book book = new Book();
            outer:
            for (; i < bookSplit.length; i++) {
                switch (i % 6) {
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
            bookMap.put(book.getBookId(), book);
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
