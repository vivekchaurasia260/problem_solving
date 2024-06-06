package com.testing.program;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,4,12,0,5,8,9,0,23,2};
        int i=0;
        int j=0;

        while(j < arr.length) {
            if(arr[i]==0 && arr[j]!=0) {
                // SWAPPING
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            if(arr[j] == 0) {
                j++;
            }
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
