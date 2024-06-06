package com.testing.program;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//MPHASIS
public class Test23 {
    public static void main(String[] args) {
        String str ="TTHYYYUUIIJJSSD";
        // count the frequency of the characters in the above String

        // STREAM API

        Map<Character, Long> result = str.chars()
                .mapToObj(ele -> (char) ele)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

    }
}
