package com.example.creditprocessor.kafka;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.creditprocessor.rabbit.CreditDecisionProducer;
import com.example.creditprocessor.rabbit.CreditDecisionEvent;
@Component
@RequiredArgsConstructor
public class CreditApplicationListener {
 private final CreditDecisionProducer producer;
 @KafkaListener(topics="${app.kafka.topic.creditApplications}", groupId="processor")
 public void receive(CreditApplicationEvent event){
  long monthlyPayment = event.creditAmount() / Math.max(event.termMonths(), 1);
  long totalMonthlyLoad = event.currentCreditLoad() + monthlyPayment;
  boolean approved = totalMonthlyLoad <= (event.income() / 2);

  if (approved) {
   producer.send(event.applicationId(), CreditDecisionEvent.Decision.APPROVED, "OK");
  } else {
   producer.send(event.applicationId(), CreditDecisionEvent.Decision.REJECTED, "Load > 50% of income");
  }
 }
}