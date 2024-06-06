package com.string.program;

import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String vowels = "aeiou";
        String result = "";

        // BY USING REG EXP
        result = str.replaceAll("[aeiouAEIOU]", "");
        System.out.println(result);

        // BY USING indexOf()
//        for(int i=0; i<str.length(); i++) {
//            if(vowels.indexOf(str.charAt(i)) == -1) {
//                result += str.charAt(i);
//            }
//        }
//
//        System.out.println(result);
    }
}
