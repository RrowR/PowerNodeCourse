package com.study.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class FlashController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("refresh")
    public ResponseEntity<String> refresh(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json;charset=utf-8");
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:" + port + "/actuator/bus-refresh", requestEntity, String.class);
        if (result.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            // 只要刷新返回204 就成功了
            // 这个是请求返回值 并不是map的业务返回值
            return ResponseEntity.ok("刷新成功");
        }
        return ResponseEntity.badRequest().body("刷新失败");
    }
}
