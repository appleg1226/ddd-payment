package com.example.purchase.domain;

import java.util.Optional;

public interface PurchaseRepository {

    String save(Purchase purchase);

    Optional<Purchase> getById(String id);
}
