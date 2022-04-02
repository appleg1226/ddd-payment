package com.example.purchase.infra.http;

import com.example.purchase.domain.Purchase;
import com.example.purchase.domain.PurchaseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @GetMapping("/{userId}")
    public List<Purchase> userPurchases(@PathVariable("userId") String userId) {
        return purchaseRepository.usersPurchase(userId);
    }
}