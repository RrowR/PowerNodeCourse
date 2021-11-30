package com.study.constant;

public interface LoginConstant {
    /*
        登陆的token前缀
     */
    String LOGIN_PREFIX = "token:";

    String[] ALLOW_URL = {"/doLogin","/getBanner","/hotProductOrRecommendation"};

    String AUTHORIZATION = "Authorization";
}
