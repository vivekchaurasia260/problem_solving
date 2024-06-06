package com.binary.program;

import java.util.Scanner;

public class BinToDec {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String binNum = "";

        while(N != 0) {
            int rem = N % 2;
            binNum = rem + binNum;
            N /= 2;
        }

        System.out.println(binNum);
    }
}
