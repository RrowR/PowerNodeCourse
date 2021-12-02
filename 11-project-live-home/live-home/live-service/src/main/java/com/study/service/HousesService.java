package com.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.domain.Houses;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.model.RentHouse;

public interface HousesService extends IService<Houses>{


    Page<Houses> searchHousePage(Integer page, String city, String content);

    void rentHouse(RentHouse rentHouse);
}
