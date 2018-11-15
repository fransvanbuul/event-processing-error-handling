package com.example.errorhandling;

import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.PropagatingErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler("B",
                c -> PropagatingErrorHandler.INSTANCE);

        /* Might do this for all event processors at once: */
//        configurer.registerDefaultListenerInvocationErrorHandler(
//                c -> PropagatingErrorHandler.INSTANCE);
    }

}
