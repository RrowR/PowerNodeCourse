package com.study.mapper;

import com.study.domain.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}