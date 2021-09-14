package service.impl;


import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.IUserService;

public class UserServiceImpl implements IUserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
