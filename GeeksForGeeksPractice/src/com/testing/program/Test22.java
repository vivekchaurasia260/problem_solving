package com.testing.program;

import java.util.HashMap;
import java.util.Map;

// GOLDMAN

public class Test22 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 9));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        // Handle edge cases
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle negative numbers
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to positive values for simplicity
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);
        num %= den;

        if (num == 0) {
            return result.toString(); // No fractional part
        }

        result.append(".");

        // Map to store previously seen remainders and their corresponding positions in the result
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            if (map.containsKey(num)) {
                // We have a repeating sequence
                result.insert(map.get(num), "(");
                result.append(")");
                break;
            }

            // Store the current remainder and its position in the result
            map.put(num, result.length());

            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }
}
