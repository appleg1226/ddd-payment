package com.example.purchase.application;

import com.example.purchase.infra.http.request.PurchaseRequest;

public interface PurchaseService {

    String purchase(PurchaseRequest request);
}
