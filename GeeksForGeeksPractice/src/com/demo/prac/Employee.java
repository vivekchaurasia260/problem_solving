package com.demo.prac;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    int id;
    String name;

    List<String> contacts = new ArrayList<>();

    public Employee(int id, String name, List<String> contacts) {
        this.id = id;
        this.name = name;

        this.contacts.addAll(contacts);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
