package com.study.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.mapper.CommentsMapper;
import com.study.domain.Comments;
import com.study.service.CommentsService;
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService{

}
