package com.example.creditprocessor.rabbit;

import com.example.creditprocessor.config.AmqpConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class CreditDecisionProducer {
 private final RabbitTemplate rabbitTemplate;
 public void send(long applicationId, CreditDecisionEvent.Decision decision, String reason){
  rabbitTemplate.convertAndSend(AmqpConfig.DECISIONS_QUEUE, new CreditDecisionEvent(applicationId, decision, reason));
 }
}