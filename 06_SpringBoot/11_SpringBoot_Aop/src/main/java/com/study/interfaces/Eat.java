package com.study.interfaces;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public interface Eat {
    public void eat(String food);
}
