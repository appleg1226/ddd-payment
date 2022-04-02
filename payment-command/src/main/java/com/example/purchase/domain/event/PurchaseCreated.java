package com.example.purchase.domain.event;

import com.example.common.event.DomainEvent;
import com.example.purchase.domain.PurchaseType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PurchaseCreated implements DomainEvent, Serializable {

    private final String userId;

    private final String purchaseId;

    private final PurchaseType type;

    private final BigDecimal amount;

    private final ZonedDateTime createdAt;

    @Override
    public String topic() {
        return "PurchaseCreated";
    }

    @Builder
    private PurchaseCreated(String userId, String purchaseId, PurchaseType type, BigDecimal amount, ZonedDateTime createdAt) {
        this.userId = userId;
        this.purchaseId = purchaseId;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
    }
}
