package com.example.fbtest;

public class Man {
    private int Age;
    private String Name;

    public Man(int age, String name) {
        Age = age;
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "Age=" + Age +
                ", Name='" + Name + '\'' +
                '}';
    }
}

