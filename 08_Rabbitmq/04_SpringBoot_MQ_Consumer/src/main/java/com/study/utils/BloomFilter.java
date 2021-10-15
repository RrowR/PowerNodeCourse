package com.study.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class BloomFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private int size = 2 << 29;

    private int[] seed = {11,13,17,19,23};

    private static final int HASH_FUN_NUM = 5;

    // 5个Hash方法的数组，用来hash5次
    private HashFun[] hashFuns = new HashFun[HASH_FUN_NUM];

    // 初始化每一个hashFun方法对象的数组，里面存储了不同的种子
    public BloomFilter(){
        for (int i = 0; i < seed.length; i++) {
            hashFuns[i] = new HashFun(size,seed[i]);
        }
    }

    /*
        添加到Redis里的位图里去，5个hash值
     */
    public void addBloom(String str){
        for (HashFun hashFun : hashFuns) {
            int pos = hashFun.getPos(str);
            // 打印每次的位置
            System.out.println(pos);
            // 将每次存储的值存到位图里去
            // key 标识 pos 值  value 是否存储
            redisTemplate.opsForValue().setBit("ddd",pos,true);
        }
    }

    public Boolean isExist(String str){
        for (HashFun hashFun : hashFuns) {
            int pos = hashFun.getPos(str);
            // 判断在redis里的位图里是否存在
            Boolean flag = redisTemplate.opsForValue().getBit("ddd", pos);
            if (!flag){
                return false;
            }
        }
        return true;
    }

}
