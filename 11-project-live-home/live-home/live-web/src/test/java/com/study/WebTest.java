package com.study;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.study.domain.User;
import com.study.service.BannerService;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WebTest {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private UserService userService;

    @Test
    void TestMapperNoScanner(){
        List<String> banner = bannerService.getBanner();
        System.out.println(banner);
    }

    @Test
    void TestSnow(){
        Snowflake snowflake = IdUtil.getSnowflake(0, 0);
        System.out.println(snowflake.nextId());
    }

    @Test
    void TestQueryByUsername(){
        User user = userService.findUserByUserName("hxd");
        System.out.println(user);
    }
}
