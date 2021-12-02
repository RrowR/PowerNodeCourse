package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.common.Result;
import com.study.domain.Comments;
import com.study.domain.Houses;
import com.study.enums.HouseEnums;
import com.study.enums.QueueEnums;
import com.study.model.RentHouse;
import com.study.service.CommentsService;
import com.study.service.HousesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("房屋搜索接口")
public class HouseController {

    @Autowired
    private HousesService housesService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("search")
    @ApiOperation("根据房屋名字搜索房屋信息")
    public Result<Page<Houses>> search(Integer page, String city, String content) {
        Page<Houses> housesPage = housesService.searchHousePage(page, city, content);
        return Result.success("ok", housesPage);
    }

    @GetMapping("details")
    @ApiOperation("查询房屋详细信息")
    public Result<Houses> details(Integer id) {
        Houses house = housesService.getById(id);
        return Result.success("ok", house);
    }

    @GetMapping("comment")
    @ApiOperation("根据id和分页对象查询分页评论")
    public Result<Page<Comments>> comment(Integer page, Integer id) {
        Page<Comments> housesPage = commentsService.getComment(id, page);
        return Result.success("ok", housesPage);
    }

    /**
     * 1.获取当前的用户信息
     * 2.每个房子只有1套
     * 3.判断这个房子是否还在？    不能查数据库，查redis
     * 4.组装一个对象，放到mq里面去(异步处理)
     *
     * @param id
     * @return
     */
    @PostMapping("buyaction")
    @ApiOperation("预定下单")
    public Result<String> buyaction(Integer id) {
        // 从 security 里获取当前用户的id信息
        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String userId = JSON.parseObject(principal).get("username").toString();
        Long count = stringRedisTemplate.opsForValue().increment(HouseEnums.HOUSE_PREFIX.getPrefix() + id);
        if (count > 3) {
            return Result.success("200", "房屋已经出租完了...");
        }
        // 让3个人进来消费
        RentHouse house = new RentHouse(id, userId);
        // 进来3个人租房，直接丢到mq里消费
        rabbitTemplate.convertAndSend(QueueEnums.RENT_HOUSE_EX.getQueueName(),QueueEnums.RENT_HOUSE_KEY.getQueueName(), JSON.toJSONString(house));
        return Result.success("200","下单成功");
    }

}
