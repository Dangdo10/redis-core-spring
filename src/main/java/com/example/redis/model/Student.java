package com.example.redis.model;

import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 101658458768L;
    private String id;
    private String name;
    private int age;

    public Student() {}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}