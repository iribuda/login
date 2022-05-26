package com.example.san.entities;

public class User {
    public String id, name, mobieNum, email, date;

    public User() {
    }

    public User(String id, String name, String mobieNum, String email, String date) {
        this.id = id;
        this.name = name;
        this.mobieNum = mobieNum;
        this.email = email;
        this.date = date;
    }
}
