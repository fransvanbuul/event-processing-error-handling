package com.example.errorhandling;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventProducer implements CommandLineRunner {

    private final EventBus eventBus;

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 10; i++) {
            DummyEvt evt = new DummyEvt("Hello " + i);
            eventBus.publish(GenericEventMessage.asEventMessage(evt));
        }
    }

}
