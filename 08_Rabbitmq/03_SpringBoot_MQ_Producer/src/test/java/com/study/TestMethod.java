package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class TestMethod {
    @Test
    public void TestUUID(){
        String uuid = UUID.randomUUID().toString();
        String s = uuid.replaceAll("-", "");
        System.out.println(uuid);
        System.out.println(s);
    }
}
