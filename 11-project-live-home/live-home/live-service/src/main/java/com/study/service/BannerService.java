package com.study.service;

import com.study.domain.Banner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BannerService extends IService<Banner>{

    List<String> getBanner();
}
