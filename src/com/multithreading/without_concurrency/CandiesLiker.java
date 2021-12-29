package com.multithreading.without_concurrency;

public class CandiesLiker extends Thread {
    public String name;
    private int sumOfAteCandies = 0;
    BoxOfCandies boxOfCandies;

    public CandiesLiker(String name, BoxOfCandies boxOfCandies) {
        this.name = name;
        this.boxOfCandies = boxOfCandies;
    }

    public CandiesLiker(String name) {
        this.name = name;
    }

    public int getSumOfAteCandies() {
        return sumOfAteCandies;
    }

    @Override
    public void run() {
        while (this.boxOfCandies.isBoxEmpty() != true) {
            this.boxOfCandies.getCandy();
            ++this.sumOfAteCandies;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
