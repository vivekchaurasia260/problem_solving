package com.java8.features;

import java.util.List;
import java.util.stream.IntStream;

public class SkipAndLimit {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 3, 6, 2, 8, 9, 1, 0, 4, 2);

        IntStream.rangeClosed(1, 17)
                .skip(4)
                .limit(9)
                .forEach(System.out::println);
    }
}
