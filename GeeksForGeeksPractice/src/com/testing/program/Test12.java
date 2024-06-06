package com.testing.program;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test12 {
    public static void main(String[] args) {

        //The number 39 will reduce as
        //Step 1 :(39 → 3x9 = 27) →
        //Step 2 : (27 → 2x7 =  14) →
        //Step 3 : (14 → 1x4 = 4)

//        int num = 1123;
//        int result = 1;
//        int temp = num;
//
//        while(temp != 0) {
//            int rem = temp%10;
//            result *= rem;
//            temp /= 10;
//
//            if(temp == 0 && result / 10 > 0) {
//                temp = result;
//                result = 1;
//            }
//        }
//
//        System.out.println("result " +result);

        //        // Sort the list based on number of occurences
//        // Input: {2, 5, 2, 6, 8, 5, 8, 2}
//        // Output: {6, 5, 5, 8, 8, 2, 2, 2}
//
        List<Integer> input = List.of(4,4,4, 2, 5, 2, 6, 8, 5, 8, 2);
        List<Integer> output = new ArrayList<>();

//        input.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue))
//                .forEach(entry -> {
//                    for(int i=0; i<entry.getValue(); i++) {
//                        output.add(entry.getKey());
//                    }
//                });

        Map<Integer, Long> sortedMap = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        //System.out.println(sortedMap);

        TreeMap<Integer, Integer> check = new TreeMap<>();
        check.put(5, 7);
        check.put(4, 3);
        check.put(9, 1);
        check.put(2, 5);
        check.put(1, 7);

        System.out.println(check);

    }
}
