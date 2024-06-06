package com.array.program;

import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeSorting {
    public static void main(String[] args) {
        int N = 7;
        long[] arr = {7, 1, 2, 3, 4, 5, 6};

        ArrayList<Long> result = alternateSort(arr, N);

        System.out.println(result);
    }
    static ArrayList<Long> alternateSort(long arr[] ,int N)
    {
        int start = 0;
        int end = N-1;
        boolean flag=false;
        ArrayList<Long> res = new ArrayList<Long>();

        Arrays.sort(arr);

        while(start <= end) {

            if(flag) {
                res.add(arr[start]);
                flag = false;
                start++;
            }
            else {
                res.add(arr[end]);
                flag = true;
                end--;
            }
        }
        return res;
    }
}



