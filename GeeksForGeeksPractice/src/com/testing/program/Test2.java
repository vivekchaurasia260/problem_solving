package com.testing.program;

import java.util.LinkedHashMap;
import java.util.Optional;

public class Test2 {
    public static void main(String[] args) {
        // aabdddeffb

//        String str = "aabdddeff";
//
//        LinkedHashMap<Character, Integer> res = new LinkedHashMap<>();
//
//        for(int i=0; i<str.length(); i++) {
//            int temp = res.getOrDefault(str.charAt(i), 0);
//
//            res.put(str.charAt(i), ++temp);
//        }
//
//        Optional<Character> firstNonRepeat = res.entrySet()
//                .stream().filter(entry -> entry.getValue() == 1)
//                .map(entry -> entry.getKey()).findFirst();
//
//        System.out.println(firstNonRepeat.get());

        int[][] arr = {{2,3,4},{5,6,7}, {1,8,9}};
        int diag1 = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                // Diagonal sum
                if(i==j || (i+j) == 2) {
                    diag1 += arr[i][j];
                }
            }
        }

        System.out.println(diag1);

//        Space : O(1)
//        Time : O(N^2)
    }
}
