package com.study.demo05;

import com.study.utils.DBUtils;

import java.sql.*;

/**
 * 根据columnLabel标签名来获取值
 */
public class Demo02SelectForName {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int pageNum = 3;
        int pageSize = 5;
        String sql = "select * from student limit " + (pageNum - 1) * pageSize + "," + pageSize + ";";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            // 数据库里的起始值是从1开始
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            Date birth = resultSet.getDate("birth");
            System.out.println("id=" + id + " name=" + name + " address=" + address + " age=" + age + " sex=" + sex + " birth=" + birth);
        }
    }
}
