package com.example.secondhandexchange.user;

public class Admin extends User {
    public Admin(String userId, String password) {
        super(userId, password, "admin");
    }
}