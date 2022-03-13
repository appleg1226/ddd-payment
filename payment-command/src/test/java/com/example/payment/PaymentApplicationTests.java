package com.example.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class PaymentApplicationTests {
    @Autowired
    KafkaTemplate<String, String> template;

    @Test
    void contextLoads() {
        template.send("topic", "hello this is new topic2!!!!!!");
    }

}
