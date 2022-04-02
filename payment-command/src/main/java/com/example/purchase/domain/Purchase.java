package com.example.purchase.domain;

import com.example.payment.domain.Payment;
import com.example.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Purchase {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn
    private User user;

    private PurchaseType type;

    private BigDecimal amount;

    @CreatedDate
    private ZonedDateTime createdAt;

    @LastModifiedDate
    private ZonedDateTime updatedAt;

    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public static Purchase of(User user, PurchaseType type, BigDecimal amount, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        return new Purchase(UUID.randomUUID().toString(), user, type, amount, createdAt, updatedAt);
    }
}
