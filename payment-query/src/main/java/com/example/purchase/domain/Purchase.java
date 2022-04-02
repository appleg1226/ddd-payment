package com.example.purchase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Purchase {

    @Id
    private String purchaseId;

    private String userId;

    private PurchaseType type;

    private BigDecimal amount;

    private ZonedDateTime createdAt;

    @Builder
    private Purchase(String purchaseId, String userId, PurchaseType type, BigDecimal amount, ZonedDateTime createdAt) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
    }
}
