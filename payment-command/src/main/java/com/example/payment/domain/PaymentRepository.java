package com.example.payment.domain;

import java.util.Optional;

public interface PaymentRepository {

    String save(Payment purchase);

    Optional<Payment> getById(String id);
}
