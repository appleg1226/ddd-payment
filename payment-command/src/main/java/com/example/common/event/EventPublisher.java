package com.example.common.event;

public interface EventPublisher {

    void publish(DomainEvent event);
}
