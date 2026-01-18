package com.example.creditapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "credit_amount", nullable = false)
    private long creditAmount;

    @Column(name = "term_months", nullable = false)
    private int termMonths;

    @Column(name = "income", nullable = false)
    private long income;

    @Column(name = "current_credit_load", nullable = false)
    private long currentCreditLoad;

    @Column(name = "credit_rating", nullable = false)
    private int creditRating;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ApplicationStatus status;
}
