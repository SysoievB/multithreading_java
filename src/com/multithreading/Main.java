package com.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
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
        }
        for (CandiesLiker t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (CandiesLiker t : threads) {
            System.out.println(threads.get(Randomizer.generate(0, 2)).getName() + " candies liker eating candy " + t.getSumOfAteCandies());

        }
    }
}
