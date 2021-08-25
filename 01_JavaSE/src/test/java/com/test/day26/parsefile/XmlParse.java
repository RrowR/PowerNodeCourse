package com.test.day26.parsefile;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 *   xml文件的解析:
 *     1. 下载dom4jxxx.xxx.jar
 *     2. 将dom4j.jar复制到项目的lib目录中
 *     3. 将dom4j.jar添加到当前模块的classPath中   右键  add as liberay
 *     4. 在代码中使用dom4j 中的SAXReader类解析xml文件中的数据
 *       4.1 使用SAXReader创建一个对象
 *            SAXReader reader=new SAXReader();
 *       4.2 调用reader.read(path) 获取Document对象
 *           Document doc=reader.read(path|File|InputStream|Reader);
 *       4.3 获取文档的根节点
 *           Element students=doc.getRootElement();
 *       4.4 获取根节点的子节点
 *           Element element(String 子元素名称);  //适用于同名的子元素只有1个
 *           List<Element> elements(String 子元素名称);  //适用于同名的子元素有多个
 *           List<Element> elements();  //获取所有的子元素
 *       4.5 获取标签体文本
 *                getText()
 *                getStringValue()
 *                getTextTrim()
 *       4.6 获取属性
 *           Attribute a = element对象.attribute(索引);
 *           Attribute a = element对象.attribute("属性名");
 *            a.getName() 获取属性名
 *            a.getValue() 获取属性值
 *           List<Attribute> list=element对象.attributes(); //获取所有的属性
 *           String value=element对象.attributeValue("属性名"); //通过属性名获取属性值
 */
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
