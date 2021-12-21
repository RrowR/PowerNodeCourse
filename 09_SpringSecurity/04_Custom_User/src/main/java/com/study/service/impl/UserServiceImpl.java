package com.study.service.impl;

import com.study.domain.SysUser;
import com.study.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过名字查询出用户信息，包括用户名和密码，当然这里的密码肯定是被加密了存在数据库里
        SysUser sysUser = userMapper.findUserByusername(username);
        if (!ObjectUtils.isEmpty(sysUser)) {
            // 业务代码、根据用户id查询到用户权限设置到用户对象里去
            List<String> auths = userMapper.findAuthsByUserId(sysUser.getUserid());
            if (!CollectionUtils.isEmpty(auths)){
//                // 将查询出来的每一个权限通过new SimpleGrantedAuthority的方式放到集合里去
//                List<SimpleGrantedAuthority> list = auths.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//                // 这个是SpringSecurity里的User
//                User user = new User(sysUser.getUsername(), sysUser.getUserpwd(), list);
                sysUser.setAuths(auths);
            }
            return sysUser;
        }
        return null;
    }
}
