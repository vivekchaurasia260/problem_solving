package com.testing.program;

import java.sql.Time;

public class Test10 {
    public static void main(String[] args) {

        // int[] arr1
        //int[] arr2

            final int[] arr1 = {2, 5, 6, 7};
            arr1[1] = 10;

            for(int x : arr1) {
                System.out.println(x);
            }

//        int[] arr2 = {4,5,6,7,8};
//
//        int N1 = arr1.length;
//        int N2 = arr2.length;
//
//        // MERGE THOSE TWO SORTED ARRAY
//        int[] arr3 = new int[N1 + N2];
//
//        int i=0;
//        int j=0;
//        int k=0;
//
//        while(i < N1 && j < N2) {
//            if(arr1[i] <= arr2[j]) {
//                arr3[k] = arr1[i];
//                i++;
//            }
//            else {
//                arr3[k] = arr2[j];
//                j++;
//            }
//
//            k++;
//        }
//
//        while(i < N1) {
//            arr3[k++] = arr1[i];
//            i++;
//        }
//
//        while(j < N2) {
//            arr3[k++] = arr2[j];
//            j++;
//        }
//
//        for(int x : arr3) {
//            System.out.print(x + " ");
//        }

        String s1 = "hello";
        String s2 = "eo";

        // s2 is a subseq of s1

//        int j = 0;
//
//        for(int i=0; i<s1.length(); i++) {
//            if(s1.charAt(i) == s2.charAt(j)) {
//                j++;
//            }
//        }
//
//        if(j == s2.length()) {
//            System.out.println("True");
//        }
//        else {
//
//        }

        // ALL EMPLOYEE WHOSE NAME STARTS WITH "A" USING STREAM

        //list.stream().filter(emp -> emp.getName().startsWith("A")).collect(Collectors.toList());

        // HIGHEST SALARY
        //list.stream().sorted(Collections.reverse(Comparator::getInteger)).findFirst();

//        String s1 = new String("abc");
//        String s2 = new String("abc");

        // s1 == s2; false;



    }
}
