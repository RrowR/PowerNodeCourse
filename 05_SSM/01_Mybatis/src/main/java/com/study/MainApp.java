package com.study;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MainApp {
    public static void main(String[] args) throws IOException {
        // 引入配置文件
        String config = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(config);
        // 解析配置文件，构建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 创建一个具体的SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 进行数据库具体会话
        Object o = sqlSession.selectOne("com.study.mapper.UserMapper.queryById1", 1);
        System.out.println(o);
    }
}
