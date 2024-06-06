package com.testing.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 extends Thread{
    public static void main(String[] args) {
//        String input = "aabbxddaaaaycca";
//        String output = "axyaabbccddaaaa";
//        String transformedString = transformString(input, output);
//        System.out.println("Transformed String: " + transformedString);
    }

    public static String transformString(String input, String output) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character in input
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        System.out.println("map " + charCountMap);

        StringBuilder transformedString = new StringBuilder();

        // Rebuild the string based on the counts from output
        for (char c : output.toCharArray()) {
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0) {
                transformedString.append(c);
                charCountMap.put(c, charCountMap.get(c) - 1);
            }
        }

        return transformedString.toString();
    }
}
