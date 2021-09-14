package com.test.day12.nighthomework.work2.code01;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(100,20.0);
        vehicle.setSpeed(200);
        vehicle.speedUp();
        vehicle.speedDown();
        vehicle.getCarMsg();

    }
}
