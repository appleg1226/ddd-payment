package com.example.purchase.infra.kafka;

import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import com.example.purchase.domain.event.PurchaseCreated;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseCreatedListener {

    private final PurchaseRepository purchaseRepository;

    @KafkaListener(topics = "PurchaseCreated", groupId = "group1")
    public void consume(PurchaseCreated message) {
        log.info("event received: {}", message);
        Purchase purchase = message.toPurchase();
        purchaseRepository.save(purchase);
    }
}