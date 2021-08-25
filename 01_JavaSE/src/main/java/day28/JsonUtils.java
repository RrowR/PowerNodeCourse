package day28;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JsonUtils {
    public static void toJsonString(Object obj) throws IllegalAccessException, ParseException {
        // 获取传入对象的字节码(对象类型)
        Class<?> clazz = obj.getClass();
        // 获取该对象里的所有字段
        Field[] declaredFields = clazz.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        // 定义一个标志
        int i = 0;
        builder.append("{");
        for (Field declaredField : declaredFields) {
            // 将私有字段设置成可以操作的，否则不能操作私有字段
            declaredField.setAccessible(true);
            // 如果这个私有属性有
            if (declaredField.isAnnotationPresent(myDateFormate.class) == true) {
                // 获取注解并且获取注解里面的值
                String dateFormat = declaredField.getAnnotation(myDateFormate.class).value();
                /*
                    问题一：  这里都是字符串，即使里面的匿名方法返回值不是一个String类型都是不会有问题的，只是不太规范
                    问题二：  将指定格式的日期转换成字符串，用的是format方法，不是parse方法，
                        format: 里面传的是一个格式，一个Date类型的日期，返回值是一个根据指定format格式和传入的Date日期返回一个格式化的String类型的日期
                            new SimpleDateFormat("yyyy-MM-dd").format(new Date())
                        parse:  将String解析成 Date
                            new SimpleDateFormat("yyyy-MM-dd").format(String str)
                    问题三:declaredField.get(obj) 返回的是 字段的属性值
                          declaredField.getName() 返回的是 这个字段的名字
                 */

                builder.append("\"" + declaredField.getName() + "\"" + ":" + "\"" + new SimpleDateFormat(dateFormat).format(declaredField.get(obj)) + "\"");
            } else {
                if (i++ == 0) {
                    builder.append("\"" + declaredField.getName() + "\"" + ":" + "\"" + declaredField.get(obj) + "\"");
                } else {
                    builder.append(",\"" + declaredField.getName() + "\"" + ":\"" + "\"" + declaredField.get(obj) + "\"");
                }
            }
        }
        System.out.println(builder.append("}").toString());
    }
}
