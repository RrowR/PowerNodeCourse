package dao.impl;


import dao.BaseDao;
import dao.UserDao;
import domain.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User login(String username, String password) {
        String sql="select id,username,password,realname as realName,role,deleted,img,create_time as createTime,update_time as updateTime,deleted_time as deletedTime from user where username = ? and password = ?";
        Object [] params={username,password};
        return super.selectOne(sql,User.class,params);
    }
}
