package com.test.day26.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FastJsonParseDemo {
    /**
    *   将对象转换成字符串使用 JSON.toJSONString 方法 返回一个JSON格式的String
    */
    @Test
    public void JsonParseObject() throws ParseException {
        String jsonString = JSON.toJSONString(new Book("001", "java", "咚咚", new SimpleDateFormat("yyyy-MM-dd").parse("2020-6-30")));
        System.out.println(jsonString);
    }

    /**
     *  将一个对象数组转换成一个字符串，数组使用的是[],每个对象使用的是{}分割，每个字段使用的是,分割，属性值使用的是:分割
     *
     *  [{"author":"咚咚","isbn":"0001","name":"c++","pubTime":"2020-07-01"},{"author":"镜华","isbn":"0001","name":"java","pubTime":"2020-06-30"},{"author":"美美","isbn":"0001","name":"c#","pubTime":"2020-06-29"},{"author":"猫羽雫","isbn":"0001","name":"python","pubTime":"2020-06-28"}]
     */
    @Test
    public void JSonParseObjectArray() throws ParseException {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("0001", "c++", "咚咚", new SimpleDateFormat("yyyy-MM-dd").parse("2020-6-31")));
        books.add(new Book("0002", "java", "镜华", new SimpleDateFormat("yyyy-MM-dd").parse("2020-6-30")));
        books.add(new Book("0003", "c#", "美美", new SimpleDateFormat("yyyy-MM-dd").parse("2020-6-29")));
        books.add(new Book("0004", "pythone", "猫羽雫", new SimpleDateFormat("yyyy-MM-dd").parse("2020-6-28")));
        String jsonString = JSON.toJSONString(books);
        System.out.println(jsonString);
    }

    @Test
    public void JsonStringToObject() {
        /**
         *  将json字符串转换成一个JSONObject对象，这个Json的底层就是一个Map，将对象的属性都当作对象存在map中，源码中就是以对象的方式来找到对应的value值
         *  public Object get(Object key) {
         *         Object val = this.map.get(key);
         *         if (val == null && (key instanceof Number || key instanceof Character || key instanceof Boolean || key instanceof UUID)) {
         *             val = this.map.get(key.toString());
         *         }
         *         return val;
         *     }
         */
        JSONObject jsonObject = JSON.parseObject("{\"author\":\"咚咚\",\"isbn\":\"001\",\"name\":\"java\",\"pubTime\":\"2020-06-30\"}");
        // 找到json中对象的key来获取value
        System.out.println(jsonObject.get("author"));
        System.out.println(jsonObject.get("isbn"));
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("pubTime"));
    }

    @Test
    public void JsonArrayStringToObject(){
        /**
         *  将json类型的字符串数组转换成一个对象数组，可以循环遍历出每个对象的信息
         *  JSON.toJSONString 同样可以将对象数组转换成一个json字符串
         */
        String str = "[{\"author\":\"咚咚\",\"isbn\":\"0001\",\"name\":\"c++\",\"pubTime\":\"2020-07-01\"},{\"author\":\"镜华\",\"isbn\":\"0002\",\"name\":\"java\",\"pubTime\":\"2020-06-30\"},{\"author\":\"美美\",\"isbn\":\"0003\",\"name\":\"c#\",\"pubTime\":\"2020-06-29\"},{\"author\":\"猫羽雫\",\"isbn\":\"0004\",\"name\":\"pythone\",\"pubTime\":\"2020-06-28\"}]";
        JSONArray objects = JSON.parseArray(str);
        System.out.println("============分割线============");
        for (Object object : objects) {
            JSONObject jsonObject = (JSONObject) object;
            System.out.println(jsonObject.get("author"));
            System.out.println(jsonObject.get("isbn"));
            System.out.println(jsonObject.get("name"));
            System.out.println(jsonObject.get("pubTime"));
        }
        System.out.println("============华丽的分割线=================");
        String jsonArrayString = JSON.toJSONString(objects);
        System.out.println(jsonArrayString);
    }

    @Test
    public void JsonArrayStringToBook(){
        /**
         *  将Json类型的字符串数组转换成对象的时候指定转换的类型，省去了向下转型，而且上面的方法还只能转成JSONObject类型
         */
        String str = "[{\"author\":\"咚咚\",\"isbn\":\"0001\",\"name\":\"c++\",\"pubTime\":\"2020-07-01\"},{\"author\":\"镜华\",\"isbn\":\"0002\",\"name\":\"java\",\"pubTime\":\"2020-06-30\"},{\"author\":\"美美\",\"isbn\":\"0003\",\"name\":\"c#\",\"pubTime\":\"2020-06-29\"},{\"author\":\"猫羽雫\",\"isbn\":\"0004\",\"name\":\"pythone\",\"pubTime\":\"2020-06-28\"}]";
        // 传入指定类型，直接返回指定类型的对象数组
        List<Book> books = JSON.parseArray(str, Book.class);
        for (Book book : books) {
            System.out.println(book.getIsbn() + " " + book.getName() + " " + book.getAuthor() + " " + new SimpleDateFormat("yyyy-MM-dd").format(book.getPubTime()));
        }
    }

    @Test
    public void JsonParseObjectArray(){
        /**
         *  使用jsonObject里的entrySet方法，获取对象的每个<k,v>属性作为entry
         */
        String str = "[{\"author\":\"咚咚\",\"isbn\":\"0001\",\"name\":\"c++\",\"pubTime\":\"2020-07-01\"},{\"author\":\"镜华\",\"isbn\":\"0002\",\"name\":\"java\",\"pubTime\":\"2020-06-30\"},{\"author\":\"美美\",\"isbn\":\"0003\",\"name\":\"c#\",\"pubTime\":\"2020-06-29\"},{\"author\":\"猫羽雫\",\"isbn\":\"0004\",\"name\":\"pythone\",\"pubTime\":\"2020-06-28\"}]";
        // 先将一个含有对象的json格式的数组通过JSON.parseArray(str)
        JSONArray jsonArray = JSON.parseArray(str);
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            // JSONObject 里有一个获取entrySet集合的方法
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }


    }
}
