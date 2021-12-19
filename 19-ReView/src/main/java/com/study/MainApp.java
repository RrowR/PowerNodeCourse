package com.study;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class MainApp {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
