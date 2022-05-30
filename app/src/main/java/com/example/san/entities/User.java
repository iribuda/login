package com.example.san.entities;

public class User {
    public String id, name, mobile, email, date;

    public User() {
    }

    public User(String id, String name, String mobile, String email, String date) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.date = date;
    }
}
