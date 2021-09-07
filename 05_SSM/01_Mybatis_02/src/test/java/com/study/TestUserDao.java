package com.study;

import com.study.dao.UserDao;
import com.study.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * 测试UserDao里的方法
 */
public class TestUserDao {
    UserDao userDao = new UserDao();

    @Test
    void Test01(){
        /*
            测试查询所有
         */
        List<User> users = userDao.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    void Test02(){
        /*
            查询一个
         */
        User user = userDao.selectOne(2);
        System.out.println(user);
    }

    @Test
    void Test03(){
        /*
            根据id删除
            注意这里的删除要手动提交事物 sqlSession.commit();
         */
        int i = userDao.deleteOne(3);
        System.out.println(i);
    }

    @Test
    void Test04(){
        /*
            增加一个
            注意：添加操作也需要提交事物
         */
        User user = new User("东方", 500, "女", "幻想乡", new Date());
        int i = userDao.addOneUser(user);
        System.out.println(i);
    }

    @Test
    void Test05(){
        /*
            更改用户
         */
        User user = new User(5, "nacho", 17, "女", "pisiv", new Date());
        int i = userDao.updateUser(user);
        System.out.println(i);
    }

}
