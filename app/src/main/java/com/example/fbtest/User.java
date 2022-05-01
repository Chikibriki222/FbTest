package com.example.fbtest;

public class User {
    public String  name, second_name;

    public User() {
    }

    public User( String name, String second_name) {

        this.name = name;
        this.second_name = second_name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String[] toArr(){
        String[] strings = new String[2];
        strings[0] = String.valueOf(getName());
        strings[1] = String.valueOf(getSecond_name());

        return strings;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
