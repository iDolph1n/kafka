package com.example.creditapi.api;

import com.example.creditapi.entity.ApplicationStatus;
import com.example.creditapi.entity.CreditApplicationEntity;
import com.example.creditapi.messaging.CreditApplicationEvent;
import com.example.creditapi.messaging.CreditApplicationPublisher;
import com.example.creditapi.repository.CreditApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
public class CreditApplicationController {

    private final CreditApplicationRepository repository;
    private final CreditApplicationPublisher publisher;

    @PostMapping
    @Transactional
    public Map<String, Long> create(@RequestBody CreateCreditApplicationRequest request) {
        CreditApplicationEntity entity = new CreditApplicationEntity();
        entity.setCreditAmount(request.creditAmount());
        entity.setTermMonths(request.termMonths());
        entity.setIncome(request.income());
        entity.setCurrentCreditLoad(request.currentCreditLoad());
        entity.setCreditRating(request.creditRating());
        entity.setStatus(ApplicationStatus.IN_PROGRESS);

        repository.save(entity);

        publisher.publish(new CreditApplicationEvent(
                entity.getId(),
                entity.getCreditAmount(),
                entity.getTermMonths(),
                entity.getIncome(),
                entity.getCurrentCreditLoad(),
                entity.getCreditRating()
        ));

        return Map.of("id", entity.getId());
    }

    @GetMapping("/{id}/status")
    public Map<String, String> status(@PathVariable long id) {
        var entity = repository.findById(id).orElseThrow();
        return Map.of("status", entity.getStatus().name());
    }
}
