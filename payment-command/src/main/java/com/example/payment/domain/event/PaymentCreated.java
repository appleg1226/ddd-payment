package com.example.payment.domain.event;

import com.example.common.event.DomainEvent;
import com.example.payment.infra.http.request.PaymentCompleteRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class PaymentCreated implements DomainEvent, Serializable {

    private final String userId;

    private final String paymentId;

    private final String cashId;

    private final BigDecimal amount;

    private final String payBy;

    private final String pgId;

    @Override
    public String topic() {
        return "PaymentCreated";
    }

    public PaymentCreated(PaymentCompleteRequest request, String userId, String paymentId, String cashId) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.cashId = cashId;
        this.amount = request.getAmount();
        this.payBy = request.getPayBy();
        this.pgId = request.getPgId();
    }

    public PaymentCreated(String userId, String paymentId, String cashId, BigDecimal amount, String payBy, String pgId) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.cashId = cashId;
        this.amount = amount;
        this.payBy = payBy;
        this.pgId = pgId;
    }
}
