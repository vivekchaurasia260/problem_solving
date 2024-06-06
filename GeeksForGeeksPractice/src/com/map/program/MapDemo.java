package com.map.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapDemo {
    public static void main(String[] args) {
        int[] arr = {3, 4, 12, 3, 12, 3, 4, 4, 12, 7, 11, 6, 5};
        int n = arr.length;

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int temp = map.getOrDefault(arr[i], 0);
            map.put(arr[i], ++temp);
        }

        map.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> res.add(entry.getKey())); //;

        System.out.println("Map " + map);


        System.out.println(res);
    }
}
