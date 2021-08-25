package com.study.demo05;

import com.study.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo01 {
    /*
        executeUpdate也可以用来执行DDL(data definition language)语句
     */
    @Test
    public void statExecQueryUpdate() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("create table tb_execUpdate02(id int (11) primary key auto_increment)");
        System.out.println(i);
        DBUtils.close(statement,connection);
    }


}
