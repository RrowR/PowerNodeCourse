package com.test.day25.Task02;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) {
        LinkedList<Food> foods = new LinkedList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Thread(new Producer(foods)));
        executorService.submit(new Thread(new Consumer(foods)));
    }
}
