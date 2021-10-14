package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("spring.boot.queue","这里Producer发过来的信息");
    }

    @Test
    void test02(){
        for (int i = 1; i <= 10; i++) {
            rabbitTemplate.convertAndSend("spring.boot.queue","这是我发过来的10条消息的其中"+i+"条");
        }
    }

    /*
        fanout广播模式
     */
    @Test
    void test03(){
        for (int i = 1; i <= 2; i++) {
            rabbitTemplate.convertAndSend("fanoutEx.boot","","这是我路由器发出的广播");
        }
    }

    /*
        路由直连模式，根据匹配的key规则来进行广播
     */
    @Test
    void Test04(){
        rabbitTemplate.convertAndSend("DirectEx","vip1","这是vip1才能接收到的内容");
        rabbitTemplate.convertAndSend("DirectEx","vip2","这是vip2才能接收到的内容");

    }
}
