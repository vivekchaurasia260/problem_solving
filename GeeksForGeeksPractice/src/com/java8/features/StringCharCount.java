package com.java8.features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharCount {
    public static void main(String[] args) {
        String str = "ilovejavatechie";

        // NUMBER OF OCCURENCE OF EACH CHARACTER
        Map<String, Long> collect = Arrays
                                .stream(str.split(""))
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        // DUPLICATE ELEMENTS IN STRING
        List<String> distinctChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(distinctChar);

        // FINDING THE FIRST NON REPEATING OCCURRENCE IN A STRING
        String firstNonRepeat = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println("First non repeating " + firstNonRepeat);

        // FIRST REPEATING CHARACTER IN STRING
        String firstRepeating = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println("First repeating " + firstRepeating);

    }
}
