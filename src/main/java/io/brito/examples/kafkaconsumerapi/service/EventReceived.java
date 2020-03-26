package io.brito.examples.kafkaconsumerapi.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EventReceived {
    private String eventName;
    private Object eventBody;
}
