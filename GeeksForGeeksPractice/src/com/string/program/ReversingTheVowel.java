package com.string.program;

import java.util.List;
import java.util.Scanner;

public class ReversingTheVowel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
//        List<Character> vowelList = List.of('a', 'e', 'i', 'o', 'u');

        // BY USING ARRAY
//        char[] arr = new char[str.length()];
//        int i=0;
//        int j=arr.length-1;
//
//        for(int k=0; k<arr.length; k++) {
//            arr[k] = str.charAt(k);
//        }
//
//        while(i < j) {
//            if(vowelList.contains(arr[i]) && vowelList.contains(arr[j])) {
//                // SWAPPING
//                char temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//            }
//            else if(vowelList.contains(arr[i]) && !vowelList.contains(arr[j])) {
//                j--;
//            }
//            else {
//                i++;
//            }
//        }
//
//        String result = "";
//
//        for(int idx=0; idx<arr.length; idx++) {
//            result += arr[idx];
//        }
//
//        System.out.println("Result is " + result);

        // BY USING STRINGBUILDER
//        StringBuilder sb = new StringBuilder(str);
//        int i=0;
//        int j=sb.length() - 1;
//
//        while(i < j) {
//            if(vowelList.contains(sb.charAt(i)) && vowelList.contains(sb.charAt(j))) {
//                char temp = sb.charAt(i);
//                sb.setCharAt(i, sb.charAt(j));
//                sb.setCharAt(j, temp);
//
//                i++;
//                j--;
//            }
//            else if(vowelList.contains(sb.charAt(i)) && !vowelList.contains(sb.charAt(j))) {
//                j--;
//            }
//            else {
//                i++;
//            }
//        }
//
//        System.out.println(sb.toString());

        // BY USING TWO POINTERS AND indexOf()
        char[] arr = str.toCharArray();
        String vowels = "aeiouAEIOU";
        int i=0;
        int j=str.length()-1;

        while(i < j) {
            if(vowels.indexOf(arr[i]) != -1 && vowels.indexOf(arr[j]) != -1) {
                // SWAPPING
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
            else if(vowels.indexOf(arr[i]) == -1 && vowels.indexOf(arr[j]) != -1) {
                i++;
            }
            else {
                j--;
            }
        }

        String word = new String(arr);

        System.out.println(word);
    }
}
