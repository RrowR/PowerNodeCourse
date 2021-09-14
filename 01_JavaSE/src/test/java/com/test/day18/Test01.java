package com.test.day18;

import org.junit.Test;
import java.util.Map;
import java.util.Properties;

public class Test01 {
    @Test
    public void Demo01(){
        Properties properties = System.getProperties();
        // 遍历出每个entrySet集合里的Entry
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey()+" --> " + entry.getValue());
        }

    }
}
