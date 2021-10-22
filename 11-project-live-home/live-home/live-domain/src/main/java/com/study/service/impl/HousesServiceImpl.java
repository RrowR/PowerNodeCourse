package com.study.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.mapper.HousesMapper;
import com.study.domain.Houses;
import com.study.service.HousesService;
@Service
public class HousesServiceImpl extends ServiceImpl<HousesMapper, Houses> implements HousesService{

}
