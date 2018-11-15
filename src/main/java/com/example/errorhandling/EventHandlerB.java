package com.example.errorhandling;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.TemporalUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

@Component
@ProcessingGroup("B")
@Slf4j
public class EventHandlerB {

    private final Instant startInstant = java.time.Instant.now();

    @EventHandler
    public void on(DummyEvt evt) {
        log.debug("Handling {} in processing group B", evt);
        if(startInstant.plus(10, SECONDS).isAfter(Instant.now())) {
            log.debug("We're still in the first 10 seconds of our existence as an event handler and " +
                    "will throw an exception intentionally");
            throw new IllegalStateException("too soon!");
        }
    }
}
