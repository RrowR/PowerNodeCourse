package com.study.demo09;

import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * JDBC中的批处理
 */
public class Demo01Batch {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            for (int i = 1;i <= 10; i++) {
                preparedStatement.setInt(1,i);
                // 这个方法在statement中照样有，只是使用prepareStatement有占位符
                preparedStatement.addBatch();
            }
            // 这个方法是错误的，结果不会执行
//            int num = preparedStatement.executeUpdate();
            // 执行prepareStatement里的executeBatch方法来执行批处理,返回值是每一条sql影响的行数
            int[] ints = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(ints));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtils.close(connection);
    }
}
