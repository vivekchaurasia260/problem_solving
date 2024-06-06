package com.testing.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// HCL

public class Test15 {
    public static void main(String[] args) {
        //Print all pairs in an unsorted array with equal sum
        //Input: A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11}
        //Output: [(( 4, 12), ( 6, 10)),(( 10, 22) ( 21, 11))..........]


        int A[] = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11};

        findPairsWithEqualSum(A);

    }

    public static void findPairsWithEqualSum(int[] arr) {
        Map<Integer, List<Pair>> sumMap =  new HashMap<>();

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int sum = arr[i] + arr[j];
                Pair pair = new Pair(arr[i], arr[j]);
                sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(pair);
            }
        }

        for(Map.Entry<Integer, List<Pair>> entry : sumMap.entrySet()) {
            List<Pair> pairs = entry.getValue();
            if(pairs.size() > 1) {
                System.out.println("Pairs with sum " + entry.getKey());

                for(Pair pair : pairs) {
                    System.out.println(pair);
                }
                System.out.println();
            }
        }
    }
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}


