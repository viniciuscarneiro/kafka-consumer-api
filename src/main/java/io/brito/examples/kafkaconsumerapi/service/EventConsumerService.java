package io.brito.examples.kafkaconsumerapi.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface EventConsumerService {
    void consume(ConsumerRecord<String, EventReceived> eventReceived);
}
