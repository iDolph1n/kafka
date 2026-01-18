package com.example.creditapi.messaging;

import com.example.creditapi.config.AmqpConfig;
import com.example.creditapi.entity.ApplicationStatus;
import com.example.creditapi.repository.CreditApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreditDecisionListener {

    private final CreditApplicationRepository repository;

    @RabbitListener(queues = AmqpConfig.DECISIONS_QUEUE)
    @Transactional
    public void handleDecision(CreditDecisionEvent event) {
        var entity = repository.findById(event.applicationId()).orElseThrow();
        entity.setStatus(
                event.decision() == CreditDecisionEvent.Decision.APPROVED
                        ? ApplicationStatus.APPROVED
                        : ApplicationStatus.REJECTED
        );
    }
}
