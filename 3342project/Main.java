package com.example.secondhandexchange;

import com.example.secondhandexchange.user.*;
import com.example.secondhandexchange.item.*;
import com.example.secondhandexchange.transaction.*;
import com.example.secondhandexchange.admin.AdminManager;
import com.example.secondhandexchange.feedback.FeedbackManager;
import com.example.secondhandexchange.feedback.Feedback;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 初始化管理系统
        UserManager userManager = new UserManager();
        ItemManager itemManager = new ItemManager();
        TransactionManager transactionManager = new TransactionManager();
        FeedbackManager feedbackManager = new FeedbackManager();
        AdminManager adminManager = new AdminManager(userManager, transactionManager);

        // 注册用户
        User seller = new Seller("seller1", "sellerpass");
        User buyer = new Buyer("buyer1", "buyerpass");
        User admin = new Admin("admin", "adminpass");

        userManager.registerUser(seller);
        userManager.registerUser(buyer);
        userManager.registerUser(admin);

        // 创建商品
        Item item = new Item("item1", "Used Laptop", "Good condition, minor scratches", 500.0, seller.getUserId());
        itemManager.createItem(item);

        // 搜索商品
        List<Item> searchResults = itemManager.searchItems("laptop");
        System.out.println("Search results:");
        for (Item result : searchResults) {
            System.out.println("Item ID: " + result.getItemId() + ", Title: " + result.getTitle());
        }

        // 创建交易
        Transaction transaction = new Transaction("txn1", buyer.getUserId(), seller.getUserId(), item.getItemId(), item.getPrice());
        transactionManager.createTransaction(transaction);

        // 选择支付方式
        transaction.setPaymentMethod(PaymentMethod.ALIPAY.toString());

        // 确认支付
        transactionManager.confirmPayment(transaction.getTransactionId());

        // 发货
        transactionManager.shipItem(transaction.getTransactionId(), ShippingMethod.STANDARD.toString());

        // 收货
        transactionManager.receiveItem(transaction.getTransactionId());

        // 提交反馈
        Feedback feedback = new Feedback("fb1", buyer.getUserId(), seller.getUserId(), 5.0, "Great communication and fast shipping!");
        feedbackManager.createFeedback(feedback);

        // 管理员监控交易
        List<Transaction> monitoredTransactions = adminManager.monitorTransactions();
        System.out.println("Monitored transactions:");
        for (Transaction txn : monitoredTransactions) {
            System.out.println("Transaction ID: " + txn.getTransactionId() + ", Status: " + txn.getStatus());
        }

        // 管理员封禁用户
        adminManager.banUser("seller1");

        // 管理员更新系统
        adminManager.updateSystem();
    }
}