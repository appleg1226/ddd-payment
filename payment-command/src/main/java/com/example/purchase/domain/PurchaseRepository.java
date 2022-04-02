package com.example.purchase.domain;

import java.util.Optional;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);

    Optional<Purchase> getById(String id);
}
