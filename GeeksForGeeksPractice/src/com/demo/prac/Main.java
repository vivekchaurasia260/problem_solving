package com.demo.prac;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       // List<String> contact = List.of("8924", "46756", "467587", "1313324")

        Employee emp1 = new Employee(101, "Vivek", List.of("2353", "2425"));

        Employee emp2 = new Employee(102, "Ramesh", List.of("899554"));

        List<Employee> employees = List.of(emp1, emp2);

        List<String> result = employees
                .stream()
                .flatMap(employee -> employee.getContacts().stream()).map(contact -> "+91 " + contact)
                .collect(Collectors.toList());

        System.out.println(result);


    }
}
