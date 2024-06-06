package com.testing.program;

import java.util.List;
import java.util.stream.Collectors;

public class Test13 {
    public static void main(String[] args) {

//        List<Integer> list1 = List.of(5,1,4,7,9,3);
//        List<Integer> list2 = List.of(35,757,22);
//
//        List<List<Integer>> input = List.of(list1, list2);
//
//        System.out.println(input);
//
//        List<Integer> result = input.
//                stream()
//                .flatMap(list -> list.stream())
//                .filter(element -> element%2 != 0)
//                .collect(Collectors.toList());
//
//        System.out.println(result);


        // RANGE :
//        int lower = 1200;
//        int upper = 1230;
//
//       // low = 1200, high = 1230
//
//        // 1001
//
//        // 11, 22, 33, ......99
//        int count=0;
//
//        for(int i=lower; i<=upper; i++) {
//
//
//
//        }
//
//        System.out.println("Result " + count);

        // CLIMB the staircase at max 2,

        // 1 or 2

        int len = 5;

        //(2,2,1) / (1,1,1,2) / (1,1,1,1,1), (1, 2, 2)
        // 1,1,1,1,1
        // 1,1,1,2
        // 1,1,2,1
        // 1,2,1,1
        // 2,1,1,1
        // 1,2,2
        // 2,1,2
        // 2,2,1


        // Employee Table
        // email column
        // shivam@gmail.com
        // ram_@yahoo.com
        // seem@air.com
        // gmail,yahoo,air

        // Select  from Employee where

        var integers = List.of(5, 2, 7, 2, 8);

        integers.forEach(System.out::println);
    }
}
