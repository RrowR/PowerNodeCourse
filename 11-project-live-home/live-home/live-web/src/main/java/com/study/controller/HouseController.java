package com.study.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.Result;
import com.study.domain.Houses;
import com.study.service.HousesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("房屋搜索接口")
public class HouseController {

    @Autowired
    private HousesService housesService;

    @GetMapping("search")
    @ApiOperation("根据房屋名字搜索房屋信息")
    public Result<Page<Houses>> search(Integer page, String city, String content) {
        Page<Houses> housesPage = housesService.searchHousePage(page, city, content);
        return Result.success("ok", housesPage);
    }

}
