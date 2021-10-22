package com.study.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.mapper.ItemsMapper;
import com.study.domain.Items;
import com.study.service.ItemsService;
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService{

}
