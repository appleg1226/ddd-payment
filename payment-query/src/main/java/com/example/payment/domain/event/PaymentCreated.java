package com.example.payment.domain.event;

import com.example.payment.domain.Payment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class PaymentCreated {

    private String userId;

    private String paymentId;

    private BigDecimal amount;

    private String payBy;

    private String pgId;

    private ZonedDateTime createdAt;

    public Payment toPayment() {
        return Payment.builder()
                      .userId(userId)
                      .paymentId(paymentId)
                      .amount(amount)
                      .payBy(payBy)
                      .pgId(pgId)
                      .createdAt(createdAt)
                      .build();
    }
}

