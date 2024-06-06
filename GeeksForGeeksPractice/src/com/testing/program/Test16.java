package com.testing.program;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test16 {
    public static void main(String[] args) {

        List<String> fruits = List.of("mango", "apple", "orange", "banana");
        //  List<Character> = {'M', 'a', 'n', }

        Set<Character> result = fruits.stream().flatMap(str -> str.chars().mapToObj(c -> (char) c)).collect(Collectors.toSet());

        System.out.println(result);

    }
}
