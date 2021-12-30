package com.multithreading.with_concurrency;

import java.util.concurrent.Semaphore;

public class WithConcurrency {

    public static void main(String[] args) {
        BoxOfCandies boxOfCandies = new BoxOfCandies(50);
        Semaphore semaphore = new Semaphore(3, false); // 3 permissions, in random order

        new Thread(new CandiesLiker("Vasia 1", boxOfCandies, semaphore)).start();
        new Thread(new CandiesLiker("Vitia 2", boxOfCandies, semaphore)).start();
        new Thread(new CandiesLiker("Valera 3", boxOfCandies, semaphore)).start();
    }
}
