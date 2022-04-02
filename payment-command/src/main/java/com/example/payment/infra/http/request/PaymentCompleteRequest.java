package com.example.payment.infra.http.request;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentCompleteRequest {

    private String userId;
    private BigDecimal amount;
    private String payBy;
    private String pgId;

    @Builder
    private PaymentCompleteRequest(String userId, BigDecimal amount, String payBy, String pgId) {
        this.userId = userId;
        this.amount = amount;
        this.payBy = payBy;
        this.pgId = pgId;
    }

    public void validate() {
        if (userId == null) {
            throw new IllegalArgumentException();
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (payBy == null) {
            throw new IllegalArgumentException();
        }
        if (pgId == null) {
            throw new IllegalArgumentException();
        }
    }
}
