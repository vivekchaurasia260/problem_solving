package com.testing.program;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {

        // Write a java program to find the number of occurances of
        // each character and non-repeated characters,
        // integers and ascii characters in a given  String using java 8 stream api.

        // I/p:- String str="11111welcome999999~!@#to%^&*the&* ( ) java{ }World12343536";

        String str = "11111welcome999999~!@#to%^&*the&* ( ) java{ }World12343536";

        Map<Character, Long> result = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        result.entrySet().stream().forEach(System.out::println);
    }
}
