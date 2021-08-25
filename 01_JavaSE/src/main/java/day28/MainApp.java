package day28;

import java.text.ParseException;
import java.util.Date;

public class MainApp {
    public static void main(String[] args) throws IllegalAccessException, ParseException {
        JsonUtils.toJsonString(new Book("123","咚咚",new Date()));
    }
}
