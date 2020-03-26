package io.brito.examples.kafkaconsumerapi.service;

import io.brito.examples.kafkaconsumerapi.domain.Event;
import io.brito.examples.kafkaconsumerapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Flux<Event> findAll() {
        return eventRepository.findAll();
    }
}
