package com.study.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtils {
    private static final SqlSessionFactory sqlSessionFactory;

    static {
        String config = "mybatis.xml";
        InputStream in = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
        try {
            in = Resources.getResourceAsStream(config);
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        }catch (Exception e){
            e.printStackTrace();
        }
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    }

    public static SqlSession getsqlSession(){
        return sqlSessionFactory.openSession();
    }
}
