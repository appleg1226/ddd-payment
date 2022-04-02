package com.example.payment.domain.event;

import com.example.common.event.DomainEvent;
import com.example.payment.infra.http.request.PaymentCompleteRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentCreated implements DomainEvent, Serializable {

    private final String userId;

    private final String paymentId;

    private final BigDecimal amount;

    private final String payBy;

    private final String pgId;

    private final ZonedDateTime createdAt;

    @Override
    public String topic() {
        return "PaymentCreated";
    }

    @Builder
    private PaymentCreated(PaymentCompleteRequest request, String userId, String paymentId, ZonedDateTime createdAt) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.amount = request.getAmount();
        this.payBy = request.getPayBy();
        this.pgId = request.getPgId();
        this.createdAt = createdAt;
    }
}
