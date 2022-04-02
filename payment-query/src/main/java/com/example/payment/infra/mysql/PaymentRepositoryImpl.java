package com.example.payment.infra.mysql;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository jpaRepository;

    @Override
    public Payment save(Payment payment) {
        return jpaRepository.save(payment);
    }

    @Override
    public List<Payment> usersPayments(String userId) {
        return jpaRepository.findByUserId(userId);
    }
}
