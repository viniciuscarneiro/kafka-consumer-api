package io.brito.examples.kafkaconsumerapi.repository;

import io.brito.examples.kafkaconsumerapi.domain.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, String> {
}
