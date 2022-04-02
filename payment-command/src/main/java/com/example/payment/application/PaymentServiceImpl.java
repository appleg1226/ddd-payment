package com.example.payment.application;

import com.example.common.event.EventPublisher;
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
        // 1. request validation
        request.validate();

        // 2. 유저의 잔액 추가 / 캐시 생성
        User user = userRepository.getByIdOrDefault(request.getUserId());
        user.increaseBalance(request.getAmount());
        userRepository.save(user);

        // 3. 결제 데이터 생성
        Payment payment = paymentRepository.save(Payment.of(request.getPgId(), request.getPayBy(), user, null, null));

        // 4. 이벤트 발행
        eventPublisher.publish(PaymentCreated.builder()
                                             .request(request)
                                             .userId(user.getUserId())
                                             .paymentId(payment.getId())
                                             .createdAt(payment.getCreatedAt())
                                             .build());

        return payment.getId();
    }
}
