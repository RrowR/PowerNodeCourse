package com.study.dao;

import com.study.domain.User;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 *  这里是指令模式，还没有到接口代理模式，也就是一个接口对应一个mapper.xml文件的形式
 */
public class UserDao {
    private SqlSession sqlSession = SqlSessionUtils.getsqlSession();
    /*
        全查询
     */
    public List<User> selectAll(){
        List<User> users = sqlSession.selectList("com.study.mapper.UserMapper.queryAllUser");
        sqlSession.close();
        return users;
    }

    /*
        查询一个
     */
    public User selectOne(Integer id){
        // 注意，条件查询的时候，这里要传一个id
        User user = sqlSession.selectOne("com.study.mapper.UserMapper.queryOneUser",id);
        sqlSession.close();
        return user;
    }

    /*
        根据id删除一个
     */
    public int deleteOne(Integer id){
        int count = sqlSession.delete("com.study.mapper.UserMapper.deleteOneUserById", id);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    /*
        添加一个User，需要提交事物
     */
    public int addOneUser(User user){
        int effect = sqlSession.insert("com.study.mapper.UserMapper.addOneUser", user);
        sqlSession.commit();
        sqlSession.close();
        return effect;
    }

    /*
        更新一个用户，需要提交事物
     */
    public int updateUser(User user){
        int effect = sqlSession.update("com.study.mapper.UserMapper.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
        return effect;

    }
}
