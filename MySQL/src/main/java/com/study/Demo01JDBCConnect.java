package com.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01JDBCConnect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String JDBC_URL="jdbc:mysql://127.0.0.1:3306/course?useUnicode=true&useSSL=false&characterEncoding=UTF8";
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL, "root", "123456");
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO student(name,address,age,sex,birth) VALUES('小明','武汉',22,'男','2020-1-1')";
        int i = statement.executeUpdate(sql);
        if ( i > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        statement.close();
        connection.close();
    }
}
