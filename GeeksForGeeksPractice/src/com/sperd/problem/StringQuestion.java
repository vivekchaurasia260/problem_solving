package com.sperd.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringQuestion {
    public static void main(String[] args) {
        //String input = "aaaaaaabbdddddkkkkxaadd";
        //String input = "aabbxddaaaaycca";

        String input = "aabbxddaaaaycca";
        String output = sortCharactersByFrequency(input);
        System.out.println("Input : \"" + input + "\"");
        System.out.println("Output : \"" + output + "\"");

    }

    public static String sortCharactersByFrequency(String input) {
        // Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Convert the map to a list of characters sorted by frequency and then by character
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return Character.compare(entry1.getKey(), entry2.getKey());
            } else {
                return Integer.compare(entry2.getValue(), entry1.getValue());
            }
        });

        // Construct the output string based on sorted frequency
        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                output.append(c);
            }
        }

        return output.toString();
    }

}
