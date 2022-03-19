package com.example.payment.application;

import com.example.payment.infra.http.request.PaymentCompleteRequest;

public interface PaymentService {

    String completePayment(PaymentCompleteRequest request);
}
