package com.example.event;

public interface EventPublisher {

    void publish(DomainEvent event);
}
