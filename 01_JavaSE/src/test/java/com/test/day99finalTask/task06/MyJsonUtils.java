package com.test.day99finalTask.task06;

import com.test.day99finalTask.task06.annotations.JsonFormat;
import com.test.day99finalTask.task06.annotations.JsonResetName;
import com.test.day99finalTask.task06.annotations.Jsonignore;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyJsonUtils {
    public static String toJsonString(Object obj) throws NoSuchFieldException, IllegalAccessException, ParseException {
       /*
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField("id");
        field.setAccessible(true);
        Object o = field.get(obj);
        System.out.println("字段为:"+field);
        System.out.println(o.toString());
        */
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        String key = null;
        String value = null;
        builder.append("{");
        for (Field field : fields) {
            field.setAccessible(true);
//            System.out.println("属性为：" + field.getName() + "属性值为：" + field.get(obj));
            if (field.isAnnotationPresent(JsonFormat.class)){
                String format = field.getAnnotation(JsonFormat.class).redate();
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                value = sdf.format(field.get(obj));
            }else {
                value = field.get(obj).toString();
            }

            if (field.isAnnotationPresent(JsonResetName.class)) {
                String username = field.getAnnotation(JsonResetName.class).reName();
                key = username;
            }else {
                key = field.getName();
            }

            if (field.isAnnotationPresent(Jsonignore.class)) {
                // 当有ignore注解的时候，直接跳过
                continue;
            }
            System.out.println(key);
            builder.append("\"" + key + "\"" + ":" + "\"" + value + "\"" + ",");
        }
        builder.append("}");
//        builder.replace(builder.length() - 2, builder.length(), "}");
        System.out.println(builder.toString().replace(",}","}"));       // String 里才有 replace
        return null;
    }
}
