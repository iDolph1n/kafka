package com.example.creditprocessor.rabbit;

public record CreditDecisionEvent(
        long applicationId,
        Decision decision,
        String reason
) {
    public enum Decision {
        APPROVED,
        REJECTED
    }
}