package com.testing.program;

import java.util.List;
import java.util.stream.Collectors;

public class Java18 {
    public static void main(String[] args) {
        List<String> words = List.of("hello", "world", "concentric", "catalyst");

        String result = "[" + String.join(", ", words) + "]";

        System.out.println(result);
    }
}
