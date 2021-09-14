package com.test.day16.Task02;

public class TestMain {
    public static void main(String[] args) {
        PCIE audioCard = new AudioCard();
        PCIE netCard = new NetCard();
        PCIE videaCard = new VideaCard();
        audioCard.send();
        netCard.send();
        videaCard.send();
    }
}
