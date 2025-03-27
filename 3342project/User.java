package com.example.secondhandexchange.user;

public class User {
    private String userId;
    private String password;
    private String role; // "buyer", "seller", "both"
    private double creditScore;

    public User(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.creditScore = 100.0; // 初始信用分
    }

    // Getter和Setter方法
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void updateCreditScore(double score) {
        this.creditScore = score;
    }
}