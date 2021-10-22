package com.study.controller;

import com.study.common.Result;
import com.study.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "轮播图管理接口")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("getBanner")
    @ApiOperation("查询轮播图接口")
    public Result getBanner(){
        List<String> paths = bannerService.getBanner();
        return Result.success("ok",paths);
    }
}
