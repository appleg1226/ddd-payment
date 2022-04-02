package com.example.purchase.infra.mysql;

import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseJpaRepository jpaRepository;

    @Override
    public Purchase save(Purchase purchase) {
        return jpaRepository.save(purchase);
    }

    @Override
    public List<Purchase> usersPurchase(String userId) {
        return jpaRepository.findByUserId(userId);
    }
}
