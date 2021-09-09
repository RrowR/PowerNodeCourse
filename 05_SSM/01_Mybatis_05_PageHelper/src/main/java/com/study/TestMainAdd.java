package com.study;

import com.study.domain.User;
import com.study.mapper.UserMapper;
import com.study.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class TestMainAdd {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getsqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("kaili", 16, "女", "岛风go", new Date());
        mapper.insertOneUser(user);
        sqlSession.commit();
        sqlSession.close();
        /*
            这里打印的user是没有id的，本身也没有，我在构造的时候就没有传id，那么这个id在代码里会显示为null
            但是在mysql里的自增下，它是有值的，我希望在插入没有id的对象的时候还能够回显id，动态显示数据库里的id值
         */
        System.out.println("user = " + user.getId());   // 成功回显id值
    }
}
