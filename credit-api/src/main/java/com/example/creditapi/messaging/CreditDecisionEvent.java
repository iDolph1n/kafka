package com.example.creditapi.messaging;

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
