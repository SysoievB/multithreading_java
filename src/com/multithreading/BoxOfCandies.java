package com.multithreading;

public class BoxOfCandies {
    public volatile int candy;

    public BoxOfCandies(int candy) {
        this.candy = candy;
    }

    public synchronized void getCandy() {
        this.candy -= 1;
    }

    public boolean isBoxEmpty() {
        return this.candy == 0;
    }
}
