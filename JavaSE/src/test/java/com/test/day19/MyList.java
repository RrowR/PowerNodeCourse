package com.test.day19;

import java.util.Iterator;

public interface MyList<T> {
    void add(T e);
    boolean remove(T e);
    int size();
    Iterator<T> iterator();
}
