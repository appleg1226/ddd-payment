package com.example.payment.infra.http;

import com.example.payment.application.PaymentService;
import com.example.payment.infra.http.request.PaymentCompleteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/payments"))
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/complete")
    public ResponseEntity<String> paymentComplete(@RequestBody PaymentCompleteRequest request) {
        return ResponseEntity.ok(paymentService.completePayment(request));
    }
}
