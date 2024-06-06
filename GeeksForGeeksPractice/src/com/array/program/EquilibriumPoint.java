package com.array.program;

import java.util.Scanner;

public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }

        int result = equilib(arr, N);

        System.out.println("result " + result);
    }

    public static int equilib(int[] arr, int N) {
        int i=0;
        int j=N-1;

        int leftSum=0;
        int rightSum=0;

        if(N==1) {
            return 1;
        }

        while(i <= j) {
            leftSum += arr[i];
            rightSum += arr[j];
            i++;
            j--;

            if((leftSum == rightSum) && leftSum!=0) {
                return i+1;
            }
        }

        return -1;
    }
}
