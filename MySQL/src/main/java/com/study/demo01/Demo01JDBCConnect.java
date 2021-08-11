package com.study.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01JDBCConnect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String JDBC_URL="jdbc:mysql://192.168.192.128:3306/course?useUnicode=true&useSSL=false&characterEncoding=UTF8&serverTimezone=UTC";
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL,"root","123456");
        Statement statement = connection.createStatement();
        String sql="INSERT INTO student(name,address,age,sex,birth) VALUES('小明','武汉',22,'男','2020-1-1')";
        String sql2="DELETE FROM student where id = 1";
        int i = statement.executeUpdate(sql2);
        if ( i > 0){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }
        statement.close();
        connection.close();
    }
}
