package io.brito.examples.kafkaconsumerapi.resource;

import io.brito.examples.kafkaconsumerapi.domain.Event;
import io.brito.examples.kafkaconsumerapi.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventResource {

    private final EventService eventService;

    @GetMapping
    public Flux<Event> findAll() {
        return eventService.findAll();
    }
}
