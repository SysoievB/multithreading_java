package com.multithreading.with_concurrency;

import java.util.concurrent.Semaphore;

public class CandiesLiker implements Runnable {
    public String name;
    private int sumOfAteCandies = 0;
    private BoxOfCandies boxOfCandies;
    Semaphore semaphore;

    public CandiesLiker(String name, BoxOfCandies boxOfCandies, Semaphore semaphore) {
        this.name = name;
        this.boxOfCandies = boxOfCandies;
        this.semaphore = semaphore;
    }

    public CandiesLiker(String name) {
        this.name = name;
    }

    public int getSumOfAteCandies() {
        return sumOfAteCandies;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            while (this.boxOfCandies.isBoxEmpty() != true) {
                this.boxOfCandies.getCandy();
                ++this.sumOfAteCandies;
                Thread.sleep(100);
                System.out.println(this.name + " candies liker eating candy " + this.getSumOfAteCandies());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
