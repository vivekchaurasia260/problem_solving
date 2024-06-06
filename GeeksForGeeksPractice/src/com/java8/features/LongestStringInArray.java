package com.java8.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestStringInArray {
    public static void main(String[] args) {
        String[] arr = {"java", "techie", "springboot", "microservices"};

        // LONGEST STRING FROM THE ARRAY (Ist APPROACH)
        String strLen = Arrays.stream(arr)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(strLen);

        // IInd APPROACH
        String strLen2 = Arrays.stream(arr)
                .max((str1, str2) -> Integer.compare(str1.length(), str2.length()))
                .orElse(null);

        System.out.println(strLen2);

    }
}
