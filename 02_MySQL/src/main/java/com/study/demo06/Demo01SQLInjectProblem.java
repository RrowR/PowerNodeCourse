package com.study.demo06;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo01SQLInjectProblem {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next().trim();
        System.out.println("请输入密码");
        String password = scanner.next().trim();
        // 此查询判断的是返回是否是一个ResultSet，如果是返回true如果不是返回false
        /*
            statement.execute()的返回值解释在源码中如下：
            true if the first result is a ResultSet object;
            false if the first result is an update count or there is no result；
         */
        ResultSet hasResult = statement.executeQuery("select * from sys_user where username = '"+username+"' and password = '"+password+"'");
        /*
            这种写法存在一个非常严重的sql注入问题
            当用户密码输入成以下格式：
            用户名:  aaa
            密码:    aaa'or'1'='1
            那么这种写法会被程序解析成一个sql语句
            select * from sys_user where username = "aaa" and password = "aaa'or'1'='1";
            在sql中返回是一个空值，但是确实有结果那么结果将会返回true
         */
        if (hasResult.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
