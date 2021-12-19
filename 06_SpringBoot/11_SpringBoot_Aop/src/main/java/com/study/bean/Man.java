package com.study.bean;


import org.springframework.stereotype.Component;

@Component
public class Man {
    public void eat(String food){

        System.out.println("man吃了"+food);
//        int a = 10/0;
    }
}
