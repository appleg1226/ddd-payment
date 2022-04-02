package com.example.purchase.infra.http;

import com.example.purchase.application.PurchaseService;
import com.example.purchase.infra.http.request.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping()
    public ResponseEntity<String> purchase(@RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(purchaseService.purchase(request));
    }
}
