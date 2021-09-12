package com.study.interfaces.impl;

import com.study.interfaces.ItargetClass;

// 需要代理的对象
public class TargetClass implements ItargetClass {
    @Override
    public void rent(int m) {
        System.out.println("租借了 = " + m + "元");
    }
}
