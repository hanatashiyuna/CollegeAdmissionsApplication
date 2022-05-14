package com.example.collegeadmissionsapplication.Models;

import java.io.Serializable;

public class Student implements Serializable {

    int nameId;
    String name, password, email;

    public Student(int nameId) {
        this.nameId = nameId;
    }

    public Student(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Student(int nameId, String name, String password, String email) {
        this.nameId = nameId;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
