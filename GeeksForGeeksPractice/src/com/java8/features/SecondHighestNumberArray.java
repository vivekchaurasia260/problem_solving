package com.java8.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class SecondHighestNumberArray {
    public static void main(String[] args) {
        int[] arr = {10, 15, 36, 13, 19, 20};

        Integer secondHigh = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(secondHigh);
    }
}
