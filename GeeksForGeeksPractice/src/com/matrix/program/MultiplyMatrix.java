package com.matrix.program;

import java.util.Scanner;

public class MultiplyMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        // INITIALIZING MATRIX
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] C = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                A[i][j] = scan.nextInt();
            }
        }

        System.out.println("-----------------------");

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                B[i][j] = scan.nextInt();
            }
        }

        // MULTIPLICATION OF TWO MATRIXs

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int mul = 0;
                for(int k=0; k<N; k++) {
                    mul += (A[i][k] * B[k][j]);
                }

                C[i][j] = mul;
            }
        }

        // PRINTING THE ELEMENT OF RESULTANT MATRICES
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(C[i][j] + " ");
            }

            System.out.println();
        }

    }
}
