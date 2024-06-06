package com.testing.program;

import java.util.PriorityQueue;

public class Test20 {
    public static void main(String[] args) {
//        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
//        int K = 3;
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a-b);
//
//        for(int i=0; i<arr.length; i++) {
//            queue.offer(arr[i]);
//
//            if(queue.size() > K) {
//                queue.poll();
//            }
//        }
//
//        // [53, 48, 6, 33, 10, 4, 2, 3, 10, 5]
//
//        System.out.println(queue.peek());

        int[] arr = {0, 1, 2, 0, 1, 2};

        int i=0;
        int left = 0;
        int right = arr.length - 1;

        while (i <= right) {
            if(arr[i] == 0) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                left++;
                i++;
            }
            else if(arr[i] == 2) {
                int temp = arr[right];
                arr[right] = arr[i];
                arr[i] = temp;
                right--;
            }
            else {
                i++;
            }
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
