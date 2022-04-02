package com.example.payment.infra.kafka;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import com.example.payment.domain.event.PaymentCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentCreatedListener {

    private final PaymentRepository paymentRepository;

    @KafkaListener(topics = "PaymentCreated", groupId = "group1")
    public void consume(PaymentCreated message) {
        log.info("event received: {}", message);
        Payment payment = message.toPayment();
        paymentRepository.save(payment);
    }
}