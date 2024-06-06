package com.pallindrome.program;

import java.util.Scanner;

public class Pallindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        long revNum = N;
        long sumNum = 0;

        for(int i=0; i<5; i++) {
            revNum = reverseNum(revNum);
            sumNum = revNum + N;

            if(sumNum == reverseNum(sumNum)) {
                System.out.println("It is Pallindrome!!");
                break;
            }
        }

        System.out.println("Outside the loop!!");
    }
    public static long reverseNum(long N) {
        long revNum = 0;

        while(N != 0) {
            long rem = N%10;

            revNum = revNum * 10 + rem;

            N/=10;
        }

        return revNum;
    }
}
