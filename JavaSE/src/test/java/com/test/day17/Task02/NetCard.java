package com.test.day17.Task02;

public class NetCard implements PCIE{
    @Override
    public void send() {
        System.out.println("网卡send message");
    }
}
