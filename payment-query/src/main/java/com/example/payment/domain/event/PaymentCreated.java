package com.example.payment.domain.event;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class PaymentCreated implements Serializable {

    private String userId;

    private String paymentId;

    private String cashId;

    private BigDecimal amount;

    private String payBy;

    private String pgId;

}
