package io.brito.examples.kafkaconsumerapi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@Configuration
@Slf4j
public class TimeZoneConfig {
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        log.info("Date in UTC: " + new Date().toString());
    }
}
