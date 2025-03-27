package com.example.secondhandexchange.feedback;

import java.util.HashMap;
import java.util.Map;

public class FeedbackManager {
    private Map<String, Feedback> feedbacks;

    public FeedbackManager() {
        this.feedbacks = new HashMap<>();
    }

    public void createFeedback(Feedback feedback) {
        if (!feedbacks.containsKey(feedback.getFeedbackId())) {
            feedbacks.put(feedback.getFeedbackId(), feedback);
            System.out.println("Feedback created successfully.");
        } else {
            System.out.println("Feedback ID already exists.");
        }
    }

    public Feedback getFeedbackById(String feedbackId) {
        return feedbacks.get(feedbackId);
    }

    public List<Feedback> getFeedbacksByUser(String userId) {
        List<Feedback> userFeedbacks = new ArrayList<>();
        for (Feedback feedback : feedbacks.values()) {
            if (feedback.getToUserId().equals(userId)) {
                userFeedbacks.add(feedback);
            }
        }
        return userFeedbacks;
    }
}