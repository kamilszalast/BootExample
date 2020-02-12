package org.example.dto;

import java.util.ArrayList;
import java.util.List;
import org.example.enums.Sex;

public class User {

    private final String name;
    private final Sex sex;
    private int age;
    private List<User> friends = new ArrayList<>();

    public User(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<User> getFriends() {
        return friends;
    }
}
