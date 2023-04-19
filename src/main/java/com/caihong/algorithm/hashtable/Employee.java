package com.caihong.algorithm.hashtable;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private int age;

    public Employee(){}
    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee && this.name.equalsIgnoreCase(((Employee) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
