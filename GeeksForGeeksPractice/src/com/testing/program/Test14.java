package com.testing.program;

// HCL
public class Test14 {
    public static void main(String[] args) {
        // Pallindrome
        // 1000
        /// 1001
        // 500

        int number = 1000;

        if(isPallindrome(number)) {
            System.out.println("Number " + number + " is pallindrome.");
        }
        else {
            int nextPallindrome = findNextPallindrome(number);
            System.out.println("The next Pallindrome is " + nextPallindrome);
        }
    }

    public static boolean isPallindrome(int number) {
        int reversed = 0;
        int original = number;

        while(number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    public static int findNextPallindrome(int number) {
        number++;

        while(!isPallindrome(number)) {
            number++;
        }

        return number;
    }
}
