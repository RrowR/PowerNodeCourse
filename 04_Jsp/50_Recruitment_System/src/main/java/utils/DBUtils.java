package utils;

import java.sql.*;
import java.util.Properties;

/**
 * 这个DBUtils的方法有如下：
 * 1.获取application.properties里的属性，从而注册指定的驱动，账号密码
 * 2.获取JDBC连接connection
 * 3.使用close方法来关闭连接和会话
 */
public class DBUtils {
    // 数据库驱动
    private static String JDBC_DRIVER;
    // 数据库连接地址
    private static String JDBC_URL;
    // 数据库账户
    private static String USERNAME;
    // 数据库密码
    private static String PASSWORD;

    static {
        // 加载数据库驱动
        try {
            Properties properties = new Properties();
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("application2.properties"));
            JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
            JDBC_URL = properties.getProperty("JDBC_URL");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 封装了返回Connection接口对象，里面是一个关于sql的连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(AutoCloseable ...autoCloseables) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            if (autoCloseables != null) {
                for (int i = 0; i < autoCloseables.length; i++) {
                    AutoCloseable autoCloseable = autoCloseables[i];
                    if (autoCloseable instanceof Connection){
                        connection = ((Connection) autoCloseable);
                    }
                    if (autoCloseable instanceof Statement){
                        statement = ((Statement) autoCloseable);
                    }
                    if (autoCloseable instanceof ResultSet){
                        resultSet = ((ResultSet) autoCloseable);
                    }
                }
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
