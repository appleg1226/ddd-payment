package com.example.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@ToString
public class User {

    @Id
    private String userId;

    private BigDecimal balance;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public String getUserId() {
        return userId;
    }

    public void increaseBalance(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public boolean hasMoreThan(BigDecimal amount) {
        return balance.compareTo(amount) > 0;
    }

    private User(String userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public static User newUser(String userId) {
        return new User(userId, BigDecimal.ZERO);
    }

    public void useCash(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}
