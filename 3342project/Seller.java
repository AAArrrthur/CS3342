package com.example.secondhandexchange.user;

public class Seller extends User {
    public Seller(String userId, String password) {
        super(userId, password, "seller");
    }
}