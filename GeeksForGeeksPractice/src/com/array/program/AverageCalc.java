package com.array.program;

import java.util.Scanner;

public class AverageCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = scan.nextInt();
        }

        double sum=0.0;

        for(int idx=0; idx<N; idx++) {
            sum += A[idx];
        }

        sum /= N;

        System.out.println(String.format("%.2f", sum));


    }
}
