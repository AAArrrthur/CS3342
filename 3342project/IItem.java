package com.example.secondhandexchange.item;

public interface IItem {
    String getItemId();
    String getTitle();
    String getDescription();
    double getPrice();
    String getSellerId();
    boolean isAvailable();
    void setAvailable(boolean available);
}