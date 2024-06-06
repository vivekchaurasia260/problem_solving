package com.testing.program;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test7 {
    public static void main(String[] args) throws IOException {

        // READ A FILE
        // FIND OUT words occurence of every char

        String path = "C:\\Users\\vivek.chaurasia\\Desktop\\file1.txt";

        try {
            // 1st sol
            //String data = new String(Files.readAllBytes(Paths.get(path)));
            Stream<String> data = Files.lines(Paths.get(path));
            Map<String, Long> result = data.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            System.out.println(result);
        }
        catch(IOException io) {
            throw new IOException("Input not valid in file");
        }

    }
}
