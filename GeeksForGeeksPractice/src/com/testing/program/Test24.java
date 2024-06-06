package com.testing.program;

import java.util.List;

// AMEX ROUND 2

public class Test24 {
    public static void main(String[] args) {

        List<Integer> list = List.of(4,6,2,7,1);
        int target = 7;

        int nearest = findNearestNumber(list, target);

        System.out.println(nearest);

    }

    public static int findNearestNumber(List<Integer> list, int target) {
        int nearestNumber = list.get(0);
        int minDifference = Math.abs(target - nearestNumber);

        for(int number : list) {
            int currentDiff = Math.abs(target - number);

            if(currentDiff < minDifference) {
                minDifference = currentDiff;
                nearestNumber = number;
            }
        }

        return nearestNumber;
    }
}
