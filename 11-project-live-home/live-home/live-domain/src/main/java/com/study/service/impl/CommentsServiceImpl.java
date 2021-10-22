package com.study.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.study.mapper.CommentsMapper;
import com.study.domain.Comments;
import com.study.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comments record) {
        return commentsMapper.insert(record);
    }

    @Override
    public int insertSelective(Comments record) {
        return commentsMapper.insertSelective(record);
    }

    @Override
    public Comments selectByPrimaryKey(Integer id) {
        return commentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comments record) {
        return commentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comments record) {
        return commentsMapper.updateByPrimaryKey(record);
    }

}
