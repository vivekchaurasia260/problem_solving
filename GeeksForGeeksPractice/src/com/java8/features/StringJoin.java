package com.java8.features;

import java.util.List;
import java.util.stream.Collectors;

public class StringJoin {
    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "6", "7");

//        List<String> stringJoin = list.stream().map(num -> num.join("-", num)).collect(Collectors.toList());
//        System.out.println(stringJoin);

        String stringJoin = String.join("-", list);
        System.out.println(stringJoin);
    }
}
