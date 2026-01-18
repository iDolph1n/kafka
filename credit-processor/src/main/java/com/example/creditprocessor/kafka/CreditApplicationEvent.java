package com.example.creditprocessor.kafka;

public record CreditApplicationEvent(
        long applicationId,
        long creditAmount,
        int termMonths,
        long income,
        long currentCreditLoad,
        int creditRating
) {
}