package org.example.config;

import nats.client.Nats;
import nats.client.NatsConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class NatsConfiguration {

    private final static String DEFAULT_NATS_HOST = "nats://127.0.0.1:4222";


    @Bean
    public Nats newNats() {
        NatsConnector natsConnector = new NatsConnector();
        natsConnector.addHost(DEFAULT_NATS_HOST);
        natsConnector.idleTimeout(Duration.ofMinutes(3).toMillis());
        return natsConnector.connect();
    }
}
