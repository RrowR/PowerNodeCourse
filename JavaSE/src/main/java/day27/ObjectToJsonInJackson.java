package day27;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class ObjectToJsonInJackson {
    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book("117", "java变成思想", "老杜", 112.2, new Date());
        ObjectMapper mapper = new ObjectMapper();
        // 对象转字符串 writeValueAsString
        String s = mapper.writeValueAsString(book);
        System.out.println(s);

        // 字符串转对象
        Book b = mapper.readValue(s, Book.class);
        System.out.println(b);


    }
}
