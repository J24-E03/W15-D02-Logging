package org.example;

public class Student {
    public String name;


    public Student(String name, int age) {
        this.name = name;

    }

    public Student(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}