package com.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStartsInArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 11, 23, 14, 1, 22, 7, 117, 21};

        List<String> startWith1 = Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .filter(ele -> ele.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(startWith1);

        // IInd Solution
        Arrays.stream(arr)
                .filter(num -> String.valueOf(num)
                .matches("^1.*"))
                .forEach(System.out::println);

    }
}
