package com.multithreading.without_concurrency;

public class Randomizer {

    public static int generate(int min, int max) {
        /*int randomNumber = min + (int) (Math.random() * ((max - min) + 1));
        if()*/
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
