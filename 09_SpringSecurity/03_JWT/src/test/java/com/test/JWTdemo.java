package com.test;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class JWTdemo {

    @Test
    public String encodeJWT(){
        HashMap<String, Object> headers = new HashMap<>(4);
        headers.put("alg","HS256");
        headers.put("typ","JWT");
        // 颁发时间
        Date createTime = new Date();
        // 过期时间 2 小时以后过期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,7200);
        // 过期时间
        Date expireTime = instance.getTime();
        String jwt = JWT.create()
                .withHeader(headers) // 头部
                .withClaim("username", "hxd")  // 载荷
                .withClaim("phone", "123213211")
                .withSubject("subject")
                .withIssuedAt(createTime)
                .withExpiresAt(expireTime)
                .sign(Algorithm.HMAC256("ddd"));// 签名
        return jwt;
    }

    @Test
    public void decode(String token){
        // JWT验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("ddd")).build();
        // 验证token
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        // 取出token里的clain里的username值
        System.out.println(decodedJWT.getClaim("phone").asString());
    }

    @Test
    void TestMainApp(){
        String jwt = encodeJWT();
        decode(jwt);
    }
}
