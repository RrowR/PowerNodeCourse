package com.study.system.mapper;

import com.study.system.domain.Role;
import com.study.system.dto.RoleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> queryAllRole(@Param("roleDto") RoleDto roleDto);
}