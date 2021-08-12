package com.study.demo08;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01Transaction {
    public static void main(String[] args){
        // 这里要定义到外面，不然在catch里将无法执行方法
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            // 注意这里的设置自动提交是connection里的方法
            connection.setAutoCommit(false);
            /*
                使用statement执行sql语句
             */
            Statement statement = connection.createStatement();
            int a= statement.executeUpdate("update account set amount = amount - 1000 where aid = 1");
            System.out.println(a);
            /*
                这里不能使用commit，这2个操作要一起完成才可以，如果这里先commit了，那么事务已经提交，
                破坏了事务的原子性(要么一起提交，要么都不提交)，不能一个执行完就直接提交，在这种情况下，2条sql语句才是一个完整的事务
             */
//            connection.commit();
            int c = 10/0;
            int b = statement.executeUpdate("update account set amount = amount + 1000 where aid = 2");
            System.out.println(b);
            // 调用connection里的commit方法
            connection.commit();
        } catch (Exception exception) {
            try {
                // 如果出现异常就回滚
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            exception.printStackTrace();
        }


    }
}
