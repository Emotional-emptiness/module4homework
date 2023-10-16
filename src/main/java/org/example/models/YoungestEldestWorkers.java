package org.example.models;

public class YoungestEldestWorkers {
    private String name;
    private int age;

    public YoungestEldestWorkers(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
