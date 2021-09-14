package com.test.day99finalTask.task05;

import java.lang.reflect.Field;

public class JsonUtils {
    public static String toJsonString(Object obj) {
        StringBuilder builder = new StringBuilder();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        builder.append("{");
        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (i == 0) {
                    if (fields[i].isAnnotationPresent(MyJsonUtils.class)){
                        String name = fields[i].getAnnotation(MyJsonUtils.class).reName();
                        builder.append("\"" + name + "\"" + ":" + "\"" + fields[i].get(obj) + "\"");
                    }else {
                        builder.append("\"" + fields[i].getName() + "\"" + ":" + "\"" + fields[i].get(obj) + "\"");
                    }
                } else {
                    if (fields[i].isAnnotationPresent(MyJsonUtils.class)){
                        String name = fields[i].getAnnotation(MyJsonUtils.class).reName();
                        builder.append("," + "\"" + name + "\"" + ":" + "\"" + fields[i].get(obj) + "\"");
                    }else {
                        builder.append("," + fields[i].getName() + "\"" + ":" + "\"" + fields[i].get(obj) + "\"");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        builder.append("}");
        return builder.toString();
    }
}
