package com.collections.program;

import java.util.ArrayList;
import java.util.Scanner;

public class PatternOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();

        ArrayList<String> result = new ArrayList<>();
        int i=0;

//        while(i < S.length()) {
//            result.add(0, S.substring(0, i+1));
//            i++;
//
//            //System.out.println(result);
//        }

        //System.out.println(result);

        result.add("Hello");
        System.out.println(result);

        result.add(0, "World");
        System.out.println(result);


    }
}
