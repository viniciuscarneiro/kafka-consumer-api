package io.brito.examples.kafkaconsumerapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.brito.examples.kafkaconsumerapi.domain.Event;
import io.brito.examples.kafkaconsumerapi.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventConsumerServiceImpl implements EventConsumerService {

    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    @SneakyThrows
    public void consume(ConsumerRecord eventReceived) {
        log.info("Event received: {}", eventReceived);
        eventRepository.save(Event.of(objectMapper.readValue(eventReceived.value().toString(), EventReceived.class))).subscribe(event -> log.info("Event saved: {}", event));
    }
}
