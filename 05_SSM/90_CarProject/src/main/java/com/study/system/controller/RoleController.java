package com.study.system.controller;

import com.github.pagehelper.Page;
import com.study.system.common.Result;
import com.study.system.domain.Role;
import com.study.system.dto.RoleDto;
import com.study.system.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /*
        分页查询
     */
    @RequestMapping("queryForPage.action")
    public Result queryForPage(RoleDto roleDto){
        // 返回了一个PageHelper包下的Page集合对象，里面是一个LogLogin,我们也只能返回一个LoginLogin，因为这个是数据库里的对象
        Page<Role> page = roleService.queryForPage(roleDto);
        return new Result("查询成功", (int) page.getTotal(),page.getResult());
    }

    /*
        根据id删除日志
     */
    @RequestMapping("delete.action")
    public Result deleteById(Integer id){
        int i = roleService.deleteByPrimaryKey(id);
        if (i > 0){
            return new Result(200,"删除成功");
        }
        return new Result(-1,"删除失败");
    }

    /*
        添加数据，传过来的只有title和content
     */
    @RequestMapping("add.action")
    public Result add(Role role){
        int i = roleService.insertSelective(role);
        if (i>0){
            return new Result(200,"添加成功");
        }else {
            return new Result(-1,"添加失败");
        }
    }

    /*
        修改数据，传过来的只有title和content
     */
    @RequestMapping("update.action")
    public Result update(Role role){
        int i = roleService.updateByPrimaryKeySelective(role);
        if (i>0){
            return new Result(200,"修改成功");
        }else {
            return new Result(-1,"修改失败");
        }
    }

}
