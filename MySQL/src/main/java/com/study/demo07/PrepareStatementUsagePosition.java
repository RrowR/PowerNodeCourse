package com.study.demo07;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 在demo06中我们看到了sql注入的问题，那么解决办法如下
 * 使用PrepareStatement可以解决SQL注入问题（可以使用占位符）
 * 但是需要使用预处理PrepareStatement对象
 */
public class PrepareStatementUsagePosition {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        // 先创建一条带占位符的sql
        String sql = "select * from sys_user where username = ? and password = ?";
        // 使用connection中的prepareStatement方法来预编译这条sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next().trim();
        // 这里是从1开始
        preparedStatement.setString(1,username);
        System.out.println("请输入密码");
        String password = scanner.next().trim();
        preparedStatement.setString(2,password);
        // 此查询判断的是返回是否是一个ResultSet，如果是返回true如果不是返回false
        boolean hasResult = preparedStatement.execute();
        /*
            这种写法存在一个非常严重的sql注入问题
            当用户密码输入成以下格式：
            用户名:  aaa
            密码:    aaa'or'1'='1
            那么这种写法会被程序解析成一个sql语句
            select * from sys_user where username = "aaa" and password = "aaa'or'1'='1";
            在sql中返回是一个空值，但是确实有结果那么结果将会返回true
         */
        if (hasResult){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
