package com.example.purchase.domain;

import java.util.List;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);

    List<Purchase> usersPurchase(String userId);
}
