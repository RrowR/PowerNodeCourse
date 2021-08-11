package com.study.demo02;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用DBUtils封装的获取connection和close方法
 * 注意：这个方法里必须是传入的CloseAble接口才可以，
 */
public class Demo01UtilsConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtils.getConnection();
        Statement statement = conn.createStatement();
        String sql="INSERT INTO student(name,address,age,sex,birth) VALUES('小明','武汉',22,'男','2020-1-1')";
        int i = statement.executeUpdate(sql);
        if ( i > 0){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }
        DBUtils.close(statement);
        DBUtils.close(conn);
    }
}
