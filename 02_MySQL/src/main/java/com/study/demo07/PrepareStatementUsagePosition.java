package com.study.demo07;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        /*
            这里不能使用execute,虽然查询不到结果，但是使用select查询不管有没有一定会有一个结果集，所以一定是会为true
            boolean hasResult = preparedStatement.execute();
            if (hasResult){
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }
        */
        ResultSet resultSet = preparedStatement.executeQuery();
        // 下一个指针的返回值,这个返回的是true或者false
        if (resultSet.next()){
            System.out.println("login access");
        }else {
            System.out.println("login fail");
        }
        DBUtils.close(resultSet,preparedStatement,connection);

    }
}
