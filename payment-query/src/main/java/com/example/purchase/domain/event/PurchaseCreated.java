package com.example.purchase.domain.event;

import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class PurchaseCreated {

    private String userId;

    private String purchaseId;

    private PurchaseType type;

    private BigDecimal amount;

    private ZonedDateTime createdAt;

    public Purchase toPurchase() {
        return Purchase.builder()
                       .purchaseId(purchaseId)
                       .userId(userId)
                       .type(type)
                       .amount(amount)
                       .createdAt(createdAt)
                       .build();
    }
}
