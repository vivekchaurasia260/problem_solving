package com.testing.program;

public class Test9 {
    public static void main(String[] args) {

        int[] arr1 = {2, 3, -1, 8, 4};
        int n = arr1.length;
        int[] prefix_sum = new int[n];
        int[] suffix_sum = new int[n];

        prefix_sum[0] = arr1[0];

        for(int i=1; i<n; i++) {
            prefix_sum[i] = prefix_sum[i-1] + arr1[i];
        }

        suffix_sum[n-1] = arr1[n-1];

        for(int i=n-2; i>=0; i--) {
            suffix_sum[i] = suffix_sum[i+1] + arr1[i];
        }

//        for(int x : suffix_sum) {
//            System.out.print(x + " ");
//        }
//
//        System.out.println();

        for(int i=0; i<n; i++) {
            if(prefix_sum[i] == suffix_sum[i]) {
                System.out.println(i);
                break;
            }
        }

    }
}
