package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.domain.Comments;
import com.study.mapper.CommentsMapper;
import com.study.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

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
}
