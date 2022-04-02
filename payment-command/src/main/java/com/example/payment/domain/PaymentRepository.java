package com.example.payment.domain;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment purchase);

    Optional<Payment> getById(String id);
}
