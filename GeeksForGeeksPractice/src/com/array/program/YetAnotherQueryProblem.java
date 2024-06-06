package com.array.program;

import java.util.ArrayList;
import java.util.Scanner;

public class YetAnotherQueryProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int num = scan.nextInt();
        int[] arr = new int[N];
        int[][] queries = {{0,4,2},{0,4,1}}; //{{0,2,2},{0,2,1},{0,4,2}}; //new int[num][num];

        // INITIALIZING ARRAY
        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }

        // INITIALIZING QUERY MATRIX
//        for(int i=0; i<num; i++) {
//            for(int j=0; j<num; j++) {
//                queries[i][j] = scan.nextInt();
//            }
//        }

        ArrayList<Integer> result = solveQueries(N, num, arr, queries);

        System.out.println(result);
    }

    public static ArrayList<Integer> solveQueries(int N, int num, int[] arr, int[][] Q) {
        int i=0;
        ArrayList<Integer> result = new ArrayList<>();

        while(--num >= 0) {
            int L = Q[i][0];
            int R = Q[i][1];
            int K = Q[i][2];
            int[] freq = new int[R-L+1];
            int idx = 0;
            int temp = 0;
            int count;

            for(int j=L; j<=R; j++) {
                count = 1;
                for(int k=j+1; k<N; k++) {
                    if(arr[j] == arr[k]) {
                        count++;
                    }
                }
                System.out.println("COUNT " + count + " " + K);

                if(count == K) {
                    temp++;
                }
            }
            System.out.println("Temp " + temp);
            result.add(temp);

            i++;
        }

        return result;
    }
}
