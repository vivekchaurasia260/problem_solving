package com.permut.program;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        long R = scan.nextLong();
        long res = 0;

        res =  factorial(N);
        System.out.println(res);

        res =  factorial(N-R);
        System.out.println(res);


    }

    public static long factorial(long num) {

        if(num < 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
