package com.testing.program;

import java.util.ArrayList;
import java.util.List;

// AMEX

public class Test21 {
    public static void main(String[] args) {
        // Write a function which takes three arguments,
        // an array of numbers, a lower limit and the upper limit.
        // The array is sorted integers where the range of elements are in the inclusive range [lower, upper],
        // you need to return its missing range. Example: ---------------- 1) array: [0, 1, 3, 50, 75],
        // lower: 0, upper: 99 ranges: ['2', '4->49', '51->74', '76->99'] 2) array: [30, 50, 70], lower: 25,
        // upper: 75 ranges: ['25->29', '31->49', '51->69', '71->75']"

        int[] arr = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        List<String> missingRanges = missingRange(lower, upper, arr);

        System.out.println(missingRanges);

    }

    public static List<String> missingRange(int lower, int upper, int[] arr) {

        List<String> result = new ArrayList<>();
        int prev = lower - 1;

        for(int i=0; i<=arr.length; i++) {

            int curr = (i < arr.length) ? arr[i] : upper + 1;

            if(prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }

            prev = curr;

        }

        return result;
    }

    public static String formatRange(int lower, int upper) {
        return (lower == upper) ?
                String.valueOf(lower) : lower + "->" + upper;
    }

}
