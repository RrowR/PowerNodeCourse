package com.study.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.system.domain.Role;
import com.study.system.dto.RoleDto;
import com.study.system.mapper.RoleMapper;
import com.study.system.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<Role> queryForPage(RoleDto roleDto) {
        Page<Role> page = PageHelper.startPage(roleDto.getPage(), roleDto.getLimit());
        List<Role> list = roleMapper.queryAllRole(roleDto);
        return  page;
    }

}
