package io.brito.examples.kafkaconsumerapi.domain;

import io.brito.examples.kafkaconsumerapi.service.EventReceived;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

    @Id
    private String id;
    private String eventName;
    private Object eventBody;
    private LocalDateTime receivedDate;

    public static Event of(EventReceived eventReceived) {
        return Event.builder()
                .eventBody(eventReceived.getEventBody())
                .eventName(eventReceived.getEventName())
                .receivedDate(LocalDateTime.now())
                .build();
    }
}
