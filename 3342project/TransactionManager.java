package com.example.secondhandexchange.transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionManager {
    private Map<String, Transaction> transactions;

    public TransactionManager() {
        this.transactions = new HashMap<>();
    }

    public void createTransaction(Transaction transaction) {
        if (!transactions.containsKey(transaction.getTransactionId())) {
            transactions.put(transaction.getTransactionId(), transaction);
            System.out.println("Transaction created successfully.");
        } else {
            System.out.println("Transaction ID already exists.");
        }
    }

    public Transaction getTransactionById(String transactionId) {
        return transactions.get(transactionId);
    }

    public void confirmPayment(String transactionId) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            transaction.setStatus("Payment Confirmed");
            System.out.println("Payment confirmed for transaction: " + transactionId);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }

    public void shipItem(String transactionId, String shippingMethod) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            transaction.setShippingMethod(shippingMethod);
            transaction.setStatus("Shipped");
            System.out.println("Item shipped for transaction: " + transactionId);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }

    public void receiveItem(String transactionId) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            transaction.setStatus("Completed");
            System.out.println("Item received for transaction: " + transactionId);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }
}