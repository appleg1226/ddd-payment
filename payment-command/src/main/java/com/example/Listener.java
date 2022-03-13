package com.example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Listener {
    @KafkaListener(topics = "topic", groupId = "group1")
    public void consume(String message) {
        System.out.println("receive message : " + message);
    }
}