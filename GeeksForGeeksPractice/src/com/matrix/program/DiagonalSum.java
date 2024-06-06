package com.matrix.program;

import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] matrix = new int[N][N];

        // INITIALIZING MATRIX
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        // PRINTING THE MATRICES
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        // DIAGONAL SUM OF MATRIX

        int diag1 = 0;
        int diag2 = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==j) {
                    diag1 += matrix[i][j];
                }
                else if((i+j) == (N-1)) {
                    diag2 += matrix[i][j];
                }
            }
        }

        System.out.println("Diagonal Sum " + diag1 +" " + diag2);
    }
}
