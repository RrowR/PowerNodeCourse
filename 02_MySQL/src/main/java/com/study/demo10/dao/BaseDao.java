package com.study.demo10.dao;

import com.study.demo10.common.PageInfo;
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
                resultSet = preparedStatement.executeQuery();
                // 获取这个结果集里的元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                // 获取这个元数据的个数(表头属性的个数)
                int columnCount = metaData.getColumnCount();
                // 遍历这个结果集，由于是id查询，结果集其实只有1个
                while (resultSet.next()) {
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
                        Object value = resultSet.getObject(columnLabel);
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
                preparedStatement.setObject(i + 1, params[i]);
            }
            effectRows = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(preparedStatement, connection);
        }
        return effectRows;
    }

    /**
     * 定义分页查询的公用方法,这里应该返回一个封装的PageInfo对象，里面的集合其实有保存的结果
     *
     * @param sql      子类传入的sql
     * @param clazz    子类传入的对象类型
     * @param pageInfo pageInfo对象，主方法里填写了页码数和显示的个数，在此方法里需要填装总个数，List<T> data 数据，总页数在Page中的set
     * @param params   分页查询的占位符的值，其实就是模糊查询的值，根据什么来进行模糊查询
     * @param <T>
     * @return
     */
    protected <T> PageInfo<T> queryForPage(String sql, Class<T> clazz, PageInfo<T> pageInfo, Object... params) {
        // 这里不需要创建集合，只需要把数据放到PageInfo里面就好了
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            // 为PageInfo设置总个数
            Long totalCount = queryTotalCount(sql, params);
            pageInfo.setTotalCount(totalCount);
            sql = sql + " limit " + (pageInfo.getPageNum() - 1) * pageInfo.getPageSize() + "," + pageInfo.getPageSize();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                // 为预处理sql设置好占位符的值
                preparedStatement.setObject(i + 1, params[i]);
            }
            // 执行预处理sql，返回一个结果集
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            /*
                ResultSet.next()指针指向下一条数据，如果有数据返回true，否则返回false
                为每一条数据创建一个空值对象，准备将数据库中的一条数据填装到这个空值对象中去
             */
            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 遍历出每个metadata上的元数据名字，和sql的占位符一样都是从1开始
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // 反射根据名字获取反射对象的字段值（没有值）
                    Field declaredField = t.getClass().getDeclaredField(columnLabel);
                    // 获取这个表指针指向的这条数据对应字段的值
                    Object object = resultSet.getObject(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, object);
                }
                // 将上面循环填装好的对象放到PageInfo<T>中的集合里去
                pageInfo.getData().add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return pageInfo;
    }

    // 根据最开始的sql条件来查询所有符合条件的数据
    private Long queryTotalCount(String sql, Object[] params) {
        Long totalCount = 0L;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            // 注意：这里的count(*) 必须写在一起
            preparedStatement = connection.prepareStatement("select count(*) from (" + sql + ") t");
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            // 这里只能使用有ResultSet作为返回值的方法，因为这个sql是一条查询语句，一定会有结果集
            resultSet = preparedStatement.executeQuery();
            // 在获取表中数据的时候一定要先执行next方法
            if (resultSet.next()){
                // 获取统计的结果个数
                totalCount = resultSet.getLong(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(preparedStatement, connection,resultSet);
        }
        return totalCount;
    }
}
