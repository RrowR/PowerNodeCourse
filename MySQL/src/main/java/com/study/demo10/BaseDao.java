package com.study.demo10;

import com.study.utils.DBUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 里面封装了查询，修改，删除，分页查询方法
 */
public class BaseDao {
    /**
     * 这是用来查询数据库的方法，传入任意对象类型，返回一个查询的集合
     *
     * @param sql    需要传入的sql
     * @param clazz  传入的对象类型
     * @param params 里面放了需要查询的条件，可能是Id，也可能是要查询的对象
     * @param <T>
     * @return
     */
    // 这是一个范型方法，由于上面的类没有定义T，但是我下面的方法需要用，需要在返回值的左边进行声明才可以
    public <T> List<T> selectList(String sql, Class<T> clazz, Object... params) {
        // 这个集合就是用来存取查询出来的对象存在集合中作为返回
        ArrayList<T> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 获取连接
            connection = DBUtils.getConnection();
            /*
                创建prepareStatement对象传入一个预执行的sql，注意此时的sql在子类中已经设置了占位符
                我们在下面直接执行结果就好了
             */
            preparedStatement = connection.prepareStatement(sql);
            if (params != null && params.length != 0) {
                // 设置占位符
                for (int i = 0; i < params.length; i++) {
                    /*
                         这里只能使用setObject，因为不知道设置的属性，但是其实每个属性都是封装到了Objects[] 里面去了
                         在这个BaseDao的子类里其实就有sql中的每个占位符对应的params属性
                     */
                    // 为预处理sql设置占位符，每个占位符都存在于Object[] params中， 顺序在子类中已经定义好
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            // 执行结果，拿到结果集
            resultSet = preparedStatement.executeQuery();
            // 获取每个结果集里上面的元数据（就是每个参数的类型）
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 获取元数据的个数
            int columnCount = metaData.getColumnCount();
            // 遍历获取resultSet结果集里的内容
            while (resultSet.next()) {
                // 获得这个方法传进来的Class对象，并创建传过来的字节码对象,假如这里是一个Student对象的字节码，那么就是new的这个对象
                T obj = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 获取每个标签属性名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // 根据获取的每一个columnLabel来获取反射字段里的每一个字段
                    Field declaredField = obj.getClass().getDeclaredField(columnLabel);
                    // 由于这个对象的字段都是私有的，需要开启访问权限
                    declaredField.setAccessible(true);
                    // 根据标签名获取结果集里字段里对应的值
                    Object object = resultSet.getObject(columnLabel);
                    //
                    declaredField.set(obj, object);
                }
                data.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return data;
    }


    /**
     * @param sql    select * from student where id = ?
     * @param clazz  Student.class
     * @param params 这个params里面放的是传入的id
     * @param <T>
     * @return
     */
    public <T> T selectOne(String sql, Class<T> clazz, Object[] params) {
        ArrayList<T> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            // 执行预处理sql
            preparedStatement = connection.prepareStatement(sql);
            if (params != null && params.length != 0) {
                // 如果这个sql有多个?就不能使用增强for循环，否则占位符位置将无法设置
                for (int i = 0; i < params.length; i++) {
                    // setObject(x,y) 一个是占位符?的位置(从1开始)，另一个是占位符的值，封装在params里
                    preparedStatement.setObject(i + 1, params[0]);
                }
                // 封装预执行sql之后，执行这条已经预执行的sql，得到一个结果集
                ResultSet rs = preparedStatement.executeQuery();
                // 获取这个结果集里的元数据
                ResultSetMetaData metaData = rs.getMetaData();
                // 获取这个元数据的个数(表头属性的个数)
                int columnCount = metaData.getColumnCount();
                // 遍历这个结果集，由于是id查询，结果集其实只有1个
                while (rs.next()) {
                    // 反射创建这个对象
                    T obj = clazz.newInstance();
                    for (int i = 0; i < columnCount; i++) {
                        // 获取这个元数据中每一个字段的属性
                        String columnLabel = metaData.getColumnLabel(i + 1);
                        // 根据这个元数据的属性名获取这个反射创建对象的每一个属性(还没有值)
                        Field declaredField = obj.getClass().getDeclaredField(columnLabel);
                        // 由于这个对象字段都是private修饰的，需要开始访问权限
                        declaredField.setAccessible(true);
                        // 根据元数据的表头名字找到这个结果集里字段对应的值value
                        Object value = rs.getObject(columnLabel);
                        // 为这每一个字段设置值,传入需要设置值的对象，转入值object
                        /*
                            循环结束之后，整个obj对象的字段值已经全部设置好了
                         */
                        declaredField.set(obj, value);
                    }
                    // 将这个对象添加到集合里面去
                    data.add(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, preparedStatement, resultSet);
        }
        // 先创建引用，否则上面将无法返回，由于这是一个通用的方法，返回值类型只能为T，否则扩展性就会很差
        T t = null;
        if (data != null && data.size() != 0) {
            t = data.get(0);
        }
        return t;
    }


    protected int executeUpdate(String sql, Object[] params) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int effectRows = 0;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1,params[i]);
            }
            effectRows = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement,connection);
        }
        return effectRows;
    }
}
