package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class DynamicSQL {
    SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    void TestIF(){
        /*
            使用mybatis里的if动态sql来进行模糊查询
         */
        List<User> users = mapper.selectOneUserByFuzzy("风","go");
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    void TestWhere(){
        /*
            使用mybatis里的where动态sql来进行模糊查询
         */
        List<User> users = mapper.selectOneUserByFuzzy2("风","go");
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    void TestSet(){
        /*
            使用mybatis里的where动态sql来进行模糊查询
         */
        User user = new User(10, "naya", 12, "女", "dream", new Date());
        int effectRows = mapper.updateUserByUser(user);
        sqlSession.commit();        // 别忘了提交事务
        sqlSession.close();
    }

    @Test
    void TestSet2(){
        /*
            使用mybatis里的where动态sql来进行模糊查询
         */
        User user = new User(11, "naya2", 12, "女", "dream", new Date());
        int effectRows = mapper.updateUserByUser2(user);
        sqlSession.commit();        // 别忘了提交事务
        sqlSession.close();
    }
}
