package com.study.bean;

import com.study.interfaces.Eat;
import org.springframework.stereotype.Component;

@Component
public class User implements Eat {

    @Override
    public void eat(String food) {
        System.out.println("User吃了"+food);
    }
}
