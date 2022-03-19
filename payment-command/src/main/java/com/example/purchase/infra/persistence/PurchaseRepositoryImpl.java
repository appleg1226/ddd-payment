package com.example.purchase.infra.persistence;

import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseJpaRepository jpaRepository;

    @Override
    public String save(Purchase purchase) {
        return jpaRepository.save(purchase).getId();
    }

    @Override
    public Optional<Purchase> getById(String id) {
        return jpaRepository.findById(id);
    }
}
