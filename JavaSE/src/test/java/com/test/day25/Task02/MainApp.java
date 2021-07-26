package com.test.day25.Task02;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) {
        LinkedList<Food> foods = new LinkedList<>();
        new Thread(new Producer(foods)).start();
        new Thread(new Consumer(foods)).start();
    }
}
