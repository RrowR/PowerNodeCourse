package com.study.service.impl;

import com.study.domain.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userService.findUserByUserName(username);
        // 可以在自己的实体类上去实现UserDetails  也可以自己创建一个类去单独实现  也可以直接用默认的实现类
        // 因为在项目中 使用id特别多  所以我们建议把用户的身份 换成用户的id
        // 就是将登录成功的对象交给springSecurity
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                dbUser.getId().toString(),
                dbUser.getPassword(),
                new HashSet<>()
        );

        return user;
    }
}
