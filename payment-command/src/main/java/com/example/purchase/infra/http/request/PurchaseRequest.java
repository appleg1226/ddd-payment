package com.example.purchase.infra.http.request;

import com.example.purchase.domain.PurchaseType;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PurchaseRequest {

    private String userId;
    private PurchaseType type;
    private BigDecimal amount;

    @Builder
    private PurchaseRequest(String userId, PurchaseType type, BigDecimal amount) {
        this.userId = userId;
        this.type = type;
        this.amount = amount;
    }

    public void validate() {
        if (userId == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new IllegalArgumentException();
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
