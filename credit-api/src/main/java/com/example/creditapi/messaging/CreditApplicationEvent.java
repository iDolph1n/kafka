package com.example.creditapi.messaging;

public record CreditApplicationEvent(
        long applicationId,
        long creditAmount,
        int termMonths,
        long income,
        long currentCreditLoad,
        int creditRating
) {
}
