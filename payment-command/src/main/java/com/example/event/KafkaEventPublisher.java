package com.example.event;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaTemplate<String, DomainEvent> kafkaProducer;

    @Override
    public void publish(DomainEvent event) {
        String topic = event.topic();
        kafkaProducer.send(new ProducerRecord<>(topic, event));
    }
}
