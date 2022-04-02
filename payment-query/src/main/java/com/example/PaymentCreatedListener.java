package com.example;

import com.example.payment.domain.event.PaymentCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentCreatedListener {

    @KafkaListener(topics = "PaymentCreated", groupId = "group1")
    public void consume(PaymentCreated message) {
        System.out.println("receive message : " + message.toString());
    }
}