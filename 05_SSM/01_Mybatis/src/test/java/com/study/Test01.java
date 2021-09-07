package com.study;

import com.study.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Test01 {
    @Test
    void Method01() throws IOException {
        // 引入配置文件
        String config = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(config);
        // 解析配置文件，构建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 创建一个具体的SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 进行数据库具体会话
        Map<String,Object> user= sqlSession.selectOne("com.study.mapper.UserMapper.queryById1", 1);
        // 这是一个map
        System.out.println(user);
        // 关闭会话
        sqlSession.close();
    }

    @Test
    void Method02() throws IOException {
        // 引入配置文件
        String config = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(config);
        // 解析配置文件，构建SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 创建一个具体的SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 进行数据库具体会话
        User user= sqlSession.selectOne("com.study.mapper.UserMapper.queryById2");
        // 这里是一个User
        System.out.println(user);
        // 关闭会话
        sqlSession.close();
    }
}
