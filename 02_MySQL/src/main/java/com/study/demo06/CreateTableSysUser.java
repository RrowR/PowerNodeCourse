package com.study.demo06;

import com.study.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建一个数据库表用来测试sql注入
 */
public class CreateTableSysUser {
    @Test
    public void createTb() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("create table sys_user(id int(11) primary key auto_increment,username varchar(255) not null,password varchar(255) not null)");
        DBUtils.close(statement,connection);
    }

    @Test
    public void insertData() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into sys_user(username,password) value ('root','123456')";
        boolean execute = statement.execute(sql);
        /*
            如果第一个结果为 ResultSet 对象，则返回 true；如果其为更新计数或者不存在任何结果，则返回 false
            所以这里返回的不是一个结果，所以返回false
         */
        System.out.println(execute);
        DBUtils.close(statement,connection);
    }
}
