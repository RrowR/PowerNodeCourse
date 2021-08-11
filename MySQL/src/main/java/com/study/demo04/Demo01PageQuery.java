package com.study.demo04;

import com.study.utils.DBUtils;

import java.sql.*;

/**
 * 分页查询
 */
public class Demo01PageQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int pageNum = 3;
        int pageSize = 5;
        String sql = "select * from student limit " + (pageNum - 1) * pageSize + "," + pageSize + ";";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            // 数据库里的起始值是从1开始
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int age = resultSet.getInt(4);
            String sex = resultSet.getString(5);
            Date birth = resultSet.getDate(6);
            System.out.println("id=" + id + " name=" + name + " address=" + address + " age=" + age + " sex=" + sex + " birth=" + birth);
        }

    }
}
