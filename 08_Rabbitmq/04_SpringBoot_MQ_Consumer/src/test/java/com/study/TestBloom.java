package com.study;

import com.study.utils.BloomFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBloom {

    @Autowired
    private BloomFilter bloomFilter;

    /*
        测试bloom过滤器，核心就是判断一个数据是否存在过，当第一次的时候会把它存到位图里
     */
    @Test
    public void TestBloom(){
        bloomFilter.addBloom("dasdada");
        System.out.println(bloomFilter.isExist("dasdada"));
        System.out.println(bloomFilter.isExist("dsadadadqweq"));
    }
}
