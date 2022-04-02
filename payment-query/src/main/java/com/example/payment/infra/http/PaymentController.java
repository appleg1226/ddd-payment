package com.example.payment.infra.http;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    @GetMapping("/{userId}")
    public List<Payment> userPayments(@PathVariable("userId") String userId) {
        return paymentRepository.usersPayments(userId);
    }
}
