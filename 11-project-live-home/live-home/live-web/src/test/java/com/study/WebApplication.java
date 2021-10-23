package com.study;

import com.study.service.BannerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WebApplication {

    @Autowired
    private BannerService bannerService;

    @Test
    void TestMapperNoScanner(){
        List<String> banner = bannerService.getBanner();
        System.out.println(banner);
    }
}
