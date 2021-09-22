package com.study.system.controller;

import com.github.pagehelper.Page;
import com.study.system.common.Result;
import com.study.system.domain.News;
import com.study.system.dto.NewsDto;
import com.study.system.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("news")
public class NewsController {

    @Resource
    private NewsService newsService;

    /*
        分页查询
     */
    @RequestMapping("queryForPage.action")
    public Result queryForPage(NewsDto newsDto){
        // 返回了一个PageHelper包下的Page集合对象，里面是一个LogLogin,我们也只能返回一个LoginLogin，因为这个是数据库里的对象
        Page<News> page = newsService.queryForPage(newsDto);
        return new Result("查询成功", (int) page.getTotal(),page.getResult());
    }

    /*
        根据id删除日志
     */
    @RequestMapping("delete.action")
    public Result deleteById(Integer id){
        int i = newsService.deleteByPrimaryKey(id);
        if (i > 0){
            return new Result(200,"删除成功");
        }
        return new Result(-1,"删除失败");
    }

    @RequestMapping("batchDel.action")
    public Result batchDel(Integer[] ids){
        newsService.batchDelete(ids);
        return new Result(200,"删除成功");
    }
}
