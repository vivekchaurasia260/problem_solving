package com.testing.program;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test25 {
    public static void main(String[] args) {

        List<Integer> list = List.of(5,1,8,4,3,7);

        // HIGHEST SECOND NUMBER : 7

        // EVEN NUMBER / ODD

        Optional<Integer> secondHighest = list.stream().sorted((o1, o2) -> o2 - o1).skip(1).findFirst();

        //System.out.println(secondHighest.get());

        List<Integer> evenElement = list.stream().filter(ele -> ele % 2 == 0).collect(Collectors.toList());
        List<Integer> oddElement  = list.stream().filter(ele -> ele %2 != 0).collect(Collectors.toList());


        System.out.println(evenElement);
        System.out.println(oddElement);

    }
}
