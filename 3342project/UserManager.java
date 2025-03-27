package com.example.secondhandexchange.user;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void registerUser(User user) {
        if (!users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User already exists.");
        }
    }

    public User loginUser(String userId, String password) {
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("User does not exist.");
        }
        return null;
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }
}