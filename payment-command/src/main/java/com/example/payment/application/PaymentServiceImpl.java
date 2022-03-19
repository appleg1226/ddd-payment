package com.example.payment.application;

import com.example.cash.domain.Cash;
import com.example.event.EventPublisher;
import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;
import com.example.payment.domain.event.PaymentCreated;
import com.example.payment.infra.http.request.PaymentCompleteRequest;
import com.example.user.domain.User;
import com.example.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final EventPublisher eventPublisher;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public String completePayment(PaymentCompleteRequest request) {
        // 1. 유저의 잔액 추가 / 캐시 생성
        User user = userRepository.getByIdOrDefault(request.getUserId());
        user.increaseBalance(request.getAmount());
        String cashId = user.addNewCash(Cash.of(request.getAmount(), user));
        userRepository.save(user);

        // 2. 결제 데이터 생성
        String paymentId = paymentRepository.save(Payment.of(request.getPgId(), request.getPayBy(), user));

        // 3. 이벤트 발행
        eventPublisher.publish(new PaymentCreated(request, user.getUserId(), paymentId, cashId));

        return paymentId;
    }
}
