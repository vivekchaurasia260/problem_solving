package com.testing.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test19 {
    public static void main(String[] args) {
        String str = "001110011100";
        // 0101101010
        // 00111 / 11100
        //00 111
        //0 11
        // output : 0011, 10, 1100;

        List<String> result = findSubstrings(str);

        System.out.println(result);

    }

    public static List<String> findSubstrings(String s) {

        // "001110011100"

        // 00111 / 00111 / 11100
        // 11100 / 01110

        List<String> result = new ArrayList<>();

        int i=0;
        int j=0;
        int count0=0;
        int count1=0;

        while(j < s.length()) {

            if(s.charAt(j) == '0') {
                count0++;
            }
            else {
                count1++;
            }

            //System.out.println(count0 + " " +count1);


            if(count0 == 2 && count1 == 3) {
                result.add(s.substring(i, j+1));
                count1 = 0;
                count0 = 0;
                i = j+1;
            }

            j++;

//
//        int n = s.length();
//
////        String targetString = "00111";
////        int tarLen = targetString.length();
//
//        for (int i=0; i<n - tarLen; i++) {
//
//            if(s.substring(i, i+tarLen).equals(targetString)) {
//                for(int j=i + tarLen; j<=n; j++) {
//
//                    result.add(s.substring(i, j));
//                }
//            }



//            int count0 = 0;
//            int count1 = 0;
//
//            for (int j=i; j<n; j++) {
//                if(s.charAt(j) == '0') {
//                    count0++;
//                }
//                else if (s.charAt(j) == '1') {
//                    count1++;
//                }
//
//                if (count0 == count1) {
//                    String substring = s.substring(i, j+1);
//                    if(substring.contains("00111")) {
//                        result.add(substring);
//                    }
//                }
//
//
//            }

        }

        return result;
    }
}
