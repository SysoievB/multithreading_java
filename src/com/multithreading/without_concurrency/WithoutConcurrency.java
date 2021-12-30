package com.multithreading.without_concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WithoutConcurrency {

    public static void main(String[] args) {
        BoxOfCandies boxOfCandies = new BoxOfCandies(50);
        ReentrantLock lock = new ReentrantLock();

        CandiesLiker candiesLikerFirst = new CandiesLiker("Vasia", boxOfCandies, lock);
        CandiesLiker candiesLikerSecond = new CandiesLiker("Vitia", boxOfCandies, lock);
        CandiesLiker candiesLikerThird = new CandiesLiker("Valera", boxOfCandies, lock);

        List<CandiesLiker> threads = new ArrayList<>(Arrays.asList(candiesLikerFirst, candiesLikerSecond, candiesLikerThird));
        Collections.shuffle(threads);
        for (var t : threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
