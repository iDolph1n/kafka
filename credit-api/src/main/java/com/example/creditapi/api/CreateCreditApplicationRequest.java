package com.example.creditapi.api;

public record CreateCreditApplicationRequest(
        long creditAmount,
        int termMonths,
        long income,
        long currentCreditLoad,
        int creditRating
) {
}
