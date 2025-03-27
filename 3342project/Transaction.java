package com.example.secondhandexchange.transaction;

public class Transaction {
    private String transactionId;
    private String buyerId;
    private String sellerId;
    private String itemId;
    private double amount;
    private String paymentMethod;
    private String shippingMethod;
    private String status;

    public Transaction(String transactionId, String buyerId, String sellerId, String itemId, double amount) {
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.itemId = itemId;
        this.amount = amount;
        this.status = "Pending";
    }

    // Getter和Setter方法
    public String getTransactionId() {
        return transactionId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getItemId() {
        return itemId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}