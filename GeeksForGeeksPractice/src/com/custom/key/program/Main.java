package com.custom.key.program;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Anand");
        Student s2 = new Student(101, "Anand");

        Set<Student> set = new HashSet<>();

        set.add(s1);
        set.add(s2);

        System.out.println(set);
    }
}
