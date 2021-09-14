package impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        Object[] params = {username,password};
        return super.selectOne(sql,User.class,params);
    }
}
