package com.study.controller;


import com.study.common.Result;
import com.study.domain.Items;
import com.study.service.ItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "商品管理接口")
public class ItemController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("hotProductOrRecommendation")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "city",value = "城市",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "type",value = "类型",dataType = "Integer",paramType = "query")
    })
    public Result<List<Items>> getHotProductOrRecommendation(String city, Integer type){
        List<Items> itemsList = itemsService.findHotProductOrRecommendation(city,type);
        return Result.success("ok",itemsList);
    }
}
