package dao;


import domain.User;

public interface UserDao {

    /**
     * 用户登陆
     */
    User login(String username, String password);
}
