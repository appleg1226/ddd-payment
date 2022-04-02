package com.example.payment.infra.persistence;

import com.example.payment.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJpaRepository extends CrudRepository<Payment, String> {
}
