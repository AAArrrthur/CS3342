package com.example.secondhandexchange.user;

public class Buyer extends User {
    public Buyer(String userId, String password) {
        super(userId, password, "buyer");
    }
}