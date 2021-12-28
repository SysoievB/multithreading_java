package com.multithreading.without_concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BoxOfCandies boxOfCandies = new BoxOfCandies(50);

        CandiesLiker candiesLikerFirst = new CandiesLiker("Vasia", boxOfCandies);
        CandiesLiker candiesLikerSecond = new CandiesLiker("Vitia", boxOfCandies);
        CandiesLiker candiesLikerThird = new CandiesLiker("Valera", boxOfCandies);

        List<CandiesLiker> threads = new ArrayList<>(Arrays.asList(candiesLikerFirst, candiesLikerSecond, candiesLikerThird));
        for (CandiesLiker t : threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
        Collections.shuffle(indexes);

        threads.forEach(t ->
                System.out.println(threads.get(indexes.stream().iterator().next()).getName() + " candies liker eating candy " + t.getSumOfAteCandies()));
    }
}
