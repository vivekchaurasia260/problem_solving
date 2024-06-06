package com.testing.program;

import java.util.*;
import java.util.stream.Collectors;

public class Test11 {
    public static void main(String[] args) {
        int[] arr = {23, 12, 56, 34, 32};
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int temp = map.getOrDefault(arr[i], 0);
            map.put(arr[i], ++temp);
        }

        List<Integer> duplicate = map.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 0)
                .map(Map.Entry::getKey).sorted()
                .toList();

        int[] result = new int[duplicate.size()];
        int k = 0;

        for(int x : duplicate) {
            result[k++] = x;
        }

        for(int x : result) {
            System.out.print(x + " ");
        }
    }
}
