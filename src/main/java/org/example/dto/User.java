package org.example.dto;

import java.time.LocalDate;
import org.example.enums.Sex;

public class User {

    private final String name;
    private final LocalDate birthDay;
    private Sex sex;
    private int age;

    public User(String name) {
        this.name = name;
        this.birthDay = LocalDate.now();
    }

    public User(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthDay = LocalDate.now();
    }

    public User(String name, LocalDate birthDay) {
        this.name = name;
        this.sex = Sex.U;
        this.age = 1;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
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
