package com.example.secondhandexchange.feedback;

public class Feedback {
    private String feedbackId;
    private String fromUserId;
    private String toUserId;
    private double rating;
    private String comment;

    public Feedback(String feedbackId, String fromUserId, String toUserId, double rating, String comment) {
        this.feedbackId = feedbackId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getter和Setter方法
    public String getFeedbackId() {
        return feedbackId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}