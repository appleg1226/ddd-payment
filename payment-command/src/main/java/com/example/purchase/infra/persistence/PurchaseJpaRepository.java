package com.example.purchase.infra.persistence;

import com.example.purchase.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseJpaRepository extends CrudRepository<Purchase, String> {
}
