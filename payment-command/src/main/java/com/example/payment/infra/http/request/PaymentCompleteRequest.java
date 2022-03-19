package com.example.payment.infra.http.request;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentCompleteRequest {

    private String userId;
    private BigDecimal amount;
    private String payBy;
    private String pgId;
}
