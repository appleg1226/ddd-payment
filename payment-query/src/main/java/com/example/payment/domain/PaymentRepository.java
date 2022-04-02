package com.example.payment.domain;

import java.util.List;

public interface PaymentRepository {

    Payment save(Payment payment);

    List<Payment> usersPayments(String userId);
}
