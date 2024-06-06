package com.testing.program;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test17 {
    public static void main(String[] args) {
        //s = "abcabcbb"
//        String str = "bbbbbbb";
//
//        Set<Character> longestSeq = new HashSet<>();
//        int ans = 0;
//        int i=0;
//        int j=0;
//
//        while(i<str.length() && j<str.length()) {
//            if(!longestSeq.contains(str.charAt(j))) {
//                longestSeq.add(str.charAt(j++));
//                ans = Math.max(ans, j-i);
//            }
//            else {
//                longestSeq.remove(str.charAt(i++));
//            }
//        }
//
//        System.out.println("Result " + ans);

        //s = "abcabcbb"

        // a=2, b=4

        String str = "abcabcbb";

        Map<Character, Long> result = str.chars()
                .mapToObj(ele -> (char) ele)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        //O(str.length())
    }
}
