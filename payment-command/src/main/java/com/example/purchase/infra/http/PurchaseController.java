package com.example.purchase.infra.http;

import com.example.common.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    @PostMapping()
    public IdResponse<Long> purchase() {
        return IdResponse.of(1L);
    }
}
