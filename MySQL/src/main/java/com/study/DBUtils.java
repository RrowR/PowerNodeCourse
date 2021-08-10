package com.study;

import java.sql.Connection;
import java.util.ResourceBundle;

public class DBUtils {
    // 数据库驱动
    public static String JDBC_DRIVER;
    // 数据库连接地址
    public static String JDBC_URL;
    // 数据库账户
    public static String username;
    // 数据库密码
    public static String password;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("application.properties");
        System.out.println();
    }


    private static void getConnection(){

    }
}
