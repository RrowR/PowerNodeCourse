package com.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Comments;
import com.study.domain.Order;
import com.study.domain.User;
import com.study.mapper.CommentsMapper;
import com.study.mapper.OrderMapper;
import com.study.mapper.UserMapper;
import com.study.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<Comments> getComment(Integer id, Integer page) {
        Page<Comments> commentsPage = new Page<>(page, 5);
        Page<Comments> comments = commentsMapper.selectPage(commentsPage, new LambdaQueryWrapper<Comments>()
                .eq(Comments::getId, id)
                .orderByDesc(Comments::getStar)
        );
        List<Comments> records = comments.getRecords();
        for (Comments comment : records) {
            String username = comment.getUsername();
            StringBuilder builder = new StringBuilder(username);
            // 进行名字的拖敏处理
            String newUserName = builder.replace(1, username.length() - 1, "***").toString();
            comment.setUsername(newUserName);
        }
        return comments;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveComm(String rate, String feelback, String orderId) {
        Order order = orderMapper.selectById(orderId);
        if (ObjectUtils.isEmpty(order)) {
            return;
        }
        // 2 设置为已评价
        order.setCommentState(2);
        int i = orderMapper.updateById(order);

        // 查询用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JSONObject jsonObject = JSON.parseObject(authentication.getPrincipal().toString());
        String userId = jsonObject.get("username").toString();
        User user = userMapper.selectById(userId);

        if (i > 0) {
            // 开始写评论表
            commentsMapper.insert(Comments.builder()
                    .comment(feelback)
                    .star(Integer.valueOf(rate))
                    .houseid(order.getHouseId().toString())
                    .username(user.getUsername())
                    .build());
        }
    }
}
