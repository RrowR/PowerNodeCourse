package com.test.day16.Task02;

public class AudioCard implements PCIE{
    @Override
    public void send() {
        System.out.println("声卡send message");
    }
}
