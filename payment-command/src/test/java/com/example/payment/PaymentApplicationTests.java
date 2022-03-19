package com.example.payment;

import com.example.payment.domain.event.PaymentCreated;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class PaymentApplicationTests {

    @Autowired
    KafkaTemplate<String, PaymentCreated> template;

    @Test
    void contextLoads() {
        PaymentCreated paymentCreated = new PaymentCreated("user", "payment", "cash", BigDecimal.ONE, "payBy", "pgId");
        template.send("PaymentCreated", paymentCreated);
    }

}
