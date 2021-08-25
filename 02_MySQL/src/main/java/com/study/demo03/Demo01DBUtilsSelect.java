package com.study.demo03;

import com.study.utils.DBUtils;

import java.sql.*;

/**
 * 使用DBUtils封装的获取connection和close方法
 * 注意：这个方法里必须是传入的CloseAble接口才可以，
 */
public class Demo01DBUtilsSelect {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();
        Statement statement = conn.createStatement();
        String sql="INSERT INTO student(name,address,age,sex,birth) VALUES('小明','武汉',22,'男','2020-1-1')";
        String sql2="select * from student";
        // 返回一个resultSet结果集
        ResultSet resultSet = statement.executeQuery(sql2);
        // 判断下一个结果集是否为空，否则返回false
        while (resultSet.next()){
            // 数据库里的起始值是从1开始
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int age = resultSet.getInt(4);
            String sex = resultSet.getString(5);
            Date birth = resultSet.getDate(6);
            System.out.println("id=" + id + " name=" + name + " address=" + address +" age=" + age +" sex=" + sex + " birth=" + birth);
        }
        DBUtils.close(resultSet,statement,conn);
    }
}
