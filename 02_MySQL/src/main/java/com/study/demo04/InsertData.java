package com.study.demo04;

import com.study.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 插入数据
 */
public class InsertData {
    /*
        创建数据库
     */
    @Test
    public void createTable() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("create table student(id int(11) primary key not null auto_increment,name varchar (10) ,address varchar (255) ,age int (11),sex char(1),birth date)");
        DBUtils.close(statement,connection);
    }

    /*
        删除student表
     */
    @Test
    public void dropTable() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("drop table student");
        DBUtils.close(statement,connection);
    }

    /*
        可以自己自定数量插入数据
     */
    @Test
    public void insertSpecifiedNumData() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String name = "用户" + i;
            String addr = "地址" + i;
            int age = random.nextInt(100);
            char sex = Math.random() > 0.5 ? '男' : '女';
            // 这里使用excute也是可以的，不能使用executeQuery
            statement.executeUpdate("insert into student(name,address,age,sex,birth) value ('" + name + "','" + addr + "','" + age + "','" + sex + "','" + formatDate + "')");
        }
        DBUtils.close(statement, connection);
    }

}
