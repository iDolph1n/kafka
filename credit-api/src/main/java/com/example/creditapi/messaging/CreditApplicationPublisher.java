package com.example.creditapi.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditApplicationPublisher {

    private final KafkaTemplate<String, CreditApplicationEvent> kafkaTemplate;

    @Value("${app.kafka.topic.creditApplications}")
    private String topic;

    public void publish(CreditApplicationEvent event) {
        kafkaTemplate.send(topic, String.valueOf(event.applicationId()), event);
    }
}
