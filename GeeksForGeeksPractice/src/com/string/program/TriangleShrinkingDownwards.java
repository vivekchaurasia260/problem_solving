package com.string.program;

import java.util.Scanner;

public class TriangleShrinkingDownwards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String result = triDownward(str);
        System.out.println("Result " + result);
    }

    public static String triDownward(String S) {
        StringBuilder sb = new StringBuilder(S);
        String res = "";

        for(int i=0; i<sb.length(); i++) {
            res += sb.toString();
            sb.setCharAt(i, '.');
        }

        return res;
    }
}
