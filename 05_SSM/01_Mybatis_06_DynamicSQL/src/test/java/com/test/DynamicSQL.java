package com.test;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        User user = new User(11, "naya3", 12, "女", "dream", new Date());
        int effectRows = mapper.updateUserByUser2(user);
        sqlSession.commit();        // 别忘了提交事务
        sqlSession.close();
    }

    @Test
    void TestForEach(){
        /*
            这里我们来进行批量添加
         */
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("东方",12,"女","characeter",new Date()));
        users.add(new User("东方2",13,"女","characeter2",new Date()));
        users.add(new User("东方3",14,"女","characeter3",new Date()));
        users.add(new User("东方4",15,"女","characeter4",new Date()));
        users.add(new User("东方5",16,"女","characeter5",new Date()));
        users.add(new User("东方6",1,"女","characeter6",new Date()));
        int effectRows = mapper.insertMutipleUsers(users);
        System.out.println("effectRows = " + effectRows);
        sqlSession.commit();
        sqlSession.close();
        users.forEach(System.out::println);
    }

    @Test
    void TestMutipleDeleteUsers(){
        // 批量删除用户
        int effectRows = mapper.deleteMutipleUsers(List.of(31, 32, 33, 34, 35));
        System.out.println("effectRows = " + effectRows);
        sqlSession.commit();
        sqlSession.commit();
    }



}
