package com.example.payment.domain;

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
public class Payment {

    @Id
    private String paymentId;

    private String userId;

    private BigDecimal amount;

    private String payBy;

    private String pgId;

    private ZonedDateTime createdAt;

    @Builder
    private Payment(String paymentId, String userId, BigDecimal amount, String payBy, String pgId, ZonedDateTime createdAt) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.payBy = payBy;
        this.pgId = pgId;
        this.createdAt = createdAt;
    }
}
