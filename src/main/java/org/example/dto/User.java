package org.example.dto;

import java.time.LocalDate;
import org.example.enums.Sex;

public class User {

    private final String name;
    private final LocalDate birthday;
    private Sex sex;
    private int age;

    public User(String name) {
        this.name = name;
        this.birthday = LocalDate.now();
    }

    public User(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = LocalDate.now();
    }

    public User(String name, LocalDate birthday) {
        this.name = name;
        this.sex = Sex.U;
        this.age = 1;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
