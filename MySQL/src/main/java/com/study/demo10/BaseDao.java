package com.study.demo10;

import com.study.demo10.entity.Student;
import com.study.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里面封装了方法，就是要在这里面调用来查询数据库
 */
public class BaseDao {
    /**
     * 这是用来查询数据库的方法，传入任意对象类型，返回一个查询的集合
     * @param sql   需要传入的sql
     * @param clazz 传入的任意对象
     * @param params   这里面放的是传入的各种参数
     * @param <T>   任意类型
     * @return
     */
    // 这是一个范型方法，由于上面的类没有定义T，但是我下面的方法需要用，需要在返回值的左边进行声明才可以
    public <T> List<T> selectList(String sql,Class<T> clazz,Object ...params){
        ArrayList<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 获取连接
            DBUtils.getConnection();
            /*
                创建prepareStatement对象传入一个预执行的sql，注意此时的sql在子类中已经设置了占位符
                我们在下面直接执行结果就好了
             */
            preparedStatement = connection.prepareStatement(sql);
            if (params != null && params.length != 0){
                for (int i = 0; i < params.length; i++) {

                }
            }
            resultSet = preparedStatement.executeQuery();
            // 获取每个结果集里上面的返回值（就是每个参数的类型）
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 获取这个（元数据）上所有参数类型的个数，为反射做准备
            int columnCount = metaData.getColumnCount();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param sql           select * from student where id = ?
     * @param clazz         Student.class
     * @param params        id
     * @param <T>           范型方法
     * @return
     */
    protected <T> Student selectOne(String sql, Class<T> clazz, Object[] params) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (params != null && params.length != 0){
            for (int i = 0; i < params.length; i++) {

            }
        }

    }
}
