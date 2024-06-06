package com.testing.program;

public class Test6 {
    public static void main(String[] args) {
        int k=0;
        int arr1[] = { 1, 3, 4, 5};
        int arr2[] = {2, 4, 6, 8};

        //Output: arr3[] = {1, 3, 4, 5, 2, 4, 6, 8}

        int[] arr3 = new int[arr1.length + arr2.length];

        for(int i=0; i<arr1.length; i++) {
            arr3[k++] = arr1[i];
        }
        for(int i=0; i<arr2.length; i++) {
            arr3[k++] = arr2[i];
        }

        for(int x : arr3) {
            System.out.print(x + " ");
        }
    }
}
