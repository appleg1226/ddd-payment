package com.example.payment.infra.persistence;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository jpaRepository;

    @Override
    public String save(Payment payment) {
        return jpaRepository.save(payment).getId();
    }

    @Override
    public Optional<Payment> getById(String id) {
        return jpaRepository.findById(id);
    }
}
