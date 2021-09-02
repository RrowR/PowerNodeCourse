package service;


import domain.User;

public interface IUserService {
    /**
     * 用户登陆
     */
    User login(String username, String password);
}
