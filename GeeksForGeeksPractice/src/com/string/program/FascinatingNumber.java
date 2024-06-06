package com.string.program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FascinatingNumber  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextInt();

        String res = isFascinating(N);
        Set<Character> set = new HashSet<>();

        for(int i=0; i<res.length(); i++) {
            set.add(res.charAt(i));
        }

        System.out.println("Set " + set);

        if(set.contains('0') || set.size() != 9) {
            System.out.println("Not Fascinating");
        }
        else {
            System.out.println("Fascinating");
        }
    }

    public static String isFascinating(long N) {
        String concatNum = "";
        concatNum = N + "" + (N*2) + "" + (N*3);

        return concatNum;
    }

    // 85317062559
}
