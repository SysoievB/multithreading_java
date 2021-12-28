package com.multithreading.with_concurrency;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        var indexes = Stream.generate(() -> (new Random()).nextInt(2)).distinct().limit(3).collect(Collectors.toList());
        for (Integer index : indexes) {
            System.out.println(index);
        }
        System.out.println("iugh");
    }
}
