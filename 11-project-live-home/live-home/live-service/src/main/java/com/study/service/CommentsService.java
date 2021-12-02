package com.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.domain.Comments;

public interface CommentsService extends IService<Comments>{


    Page<Comments> getComment(Integer id, Integer page);
}
