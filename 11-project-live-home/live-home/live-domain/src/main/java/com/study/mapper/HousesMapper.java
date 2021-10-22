package com.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.domain.Houses;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HousesMapper extends BaseMapper<Houses> {
}