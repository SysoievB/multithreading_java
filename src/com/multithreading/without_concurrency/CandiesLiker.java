package com.multithreading.without_concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class CandiesLiker extends Thread {
    public String name;
    private int sumOfAteCandies = 0;
    private BoxOfCandies boxOfCandies;
    private ReentrantLock lock;

    public CandiesLiker(String name, BoxOfCandies boxOfCandies, ReentrantLock lock) {
        this.name = name;
        this.boxOfCandies = boxOfCandies;
        this.lock = lock;
    }

    public CandiesLiker(String name) {
        this.name = name;
    }

    public int getSumOfAteCandies() {
        return sumOfAteCandies;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (this.boxOfCandies.isBoxEmpty() != true) {
                this.boxOfCandies.getCandy();
                ++this.sumOfAteCandies;
                System.out.println(this.name + " candies liker eating candy " + this.getSumOfAteCandies());

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
