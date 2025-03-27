package com.example.secondhandexchange.admin;

import com.example.secondhandexchange.user.User;
import com.example.secondhandexchange.user.UserManager;
import com.example.secondhandexchange.transaction.Transaction;
import com.example.secondhandexchange.transaction.TransactionManager;

public class AdminManager {
    private UserManager userManager;
    private TransactionManager transactionManager;

    public AdminManager(UserManager userManager, TransactionManager transactionManager) {
        this.userManager = userManager;
        this.transactionManager = transactionManager;
    }

    public List<Transaction> monitorTransactions() {
        return new ArrayList<>(transactionManager.transactions.values());
    }

    public void banUser(String userId) {
        User user = userManager.getUserById(userId);
        if (user != null) {
            user.updateCreditScore(0.0);
            System.out.println("User " + userId + " has been banned.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    public void updateSystem() {
        // 实现系统更新逻辑
        System.out.println("System updated successfully.");
    }
}