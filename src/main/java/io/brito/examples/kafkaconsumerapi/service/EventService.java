package io.brito.examples.kafkaconsumerapi.service;

import io.brito.examples.kafkaconsumerapi.domain.Event;
import reactor.core.publisher.Flux;

public interface EventService {
    Flux<Event> findAll();
}
