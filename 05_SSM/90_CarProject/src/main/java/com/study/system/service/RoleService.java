package com.study.system.service;

import com.github.pagehelper.Page;
import com.study.system.domain.Role;
import com.study.system.dto.RoleDto;

public interface RoleService{


    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Page<Role> queryForPage(RoleDto roleDto);
}
