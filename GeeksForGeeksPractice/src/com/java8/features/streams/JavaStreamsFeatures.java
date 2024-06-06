package com.java8.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsFeatures {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("Sirius", "Raj", null, "Rajat", "Sam", "Pankaj", null, "Mani", "Aron");

        // if we want to remove nullable from List
        // Ist approach

        List<String> result1 = elements.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println(result1);

        // IInd approach
        List<String> result2 = elements.stream()
                .flatMap(Stream::ofNullable)
                .toList();

        System.out.println(result2);


        // iterator()
//        Stream.iterate(1, n -> n+2)
//                .limit(5)
//                .forEach(System.out::println);

        // collectingAndThen()

        // takeWhile() & dropWhile()
        List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 22, 78, 2, 92, 18, 11, 15);

        List<Integer> res = numbers.stream().takeWhile(num -> num < 22).collect(Collectors.toList());
        System.out.println(res);

        List<Integer> res2 = numbers.stream().dropWhile(num -> num < 15).collect(Collectors.toList());
        System.out.println(res2);

    }
}
