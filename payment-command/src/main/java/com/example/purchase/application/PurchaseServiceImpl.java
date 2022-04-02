package com.example.purchase.application;

import com.example.common.event.EventPublisher;
import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import com.example.purchase.domain.event.PurchaseCreated;
import com.example.purchase.infra.http.request.PurchaseRequest;
import com.example.user.domain.User;
import com.example.user.domain.UserRepository;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final UserRepository userRepository;
    private final PurchaseRepository purchaseRepository;
    private final EventPublisher eventPublisher;

    @Override
    @Transactional
    public String purchase(PurchaseRequest request) {
        // 1. request validation
        request.validate();

        // 2. 유저 존재 여부 확인
        User foundUser = userRepository.findById(request.getUserId()).orElseThrow(NoSuchElementException::new);

        // 3. 잔액 여유 확인
        if (!foundUser.hasMoreThan(request.getAmount())) {
            throw new IllegalArgumentException(); // TODO 커스텀 Exception으로 변경
        }

        // 4. 캐시 차감
        foundUser.useCash(request.getAmount());
        userRepository.save(foundUser);

        // 5. 구매 기록 추가
        Purchase purchase = purchaseRepository.save(Purchase.of(foundUser, request.getType(), request.getAmount(), null, null));

        // 6. 이벤트 발행
        eventPublisher.publish(PurchaseCreated.builder()
                                              .userId(foundUser.getUserId())
                                              .purchaseId(purchase.getId())
                                              .type(request.getType())
                                              .amount(request.getAmount())
                                              .createdAt(purchase.getCreatedAt())
                                              .build());

        return purchase.getId();
    }
}
