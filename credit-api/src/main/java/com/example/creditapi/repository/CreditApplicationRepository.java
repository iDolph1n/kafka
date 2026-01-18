package com.example.creditapi.repository;

import com.example.creditapi.entity.CreditApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditApplicationRepository extends JpaRepository<CreditApplicationEntity, Long> {
}
