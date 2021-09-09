package org.example.service;

import nats.client.Message;
import nats.client.MessageHandler;
import nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class SubscribeService {

    private static final Logger logger = LoggerFactory.getLogger(SubscribeService.class);

    @Autowired
    private Nats nc;

    @Bean
    public void subscribeHello() {
        nc.subscribe("hello", new MessageHandler() {
            @Override
            public void onMessage(Message message) {
                logger.info("received message: {}", message.getBody());
            }
        });
    }

    @Bean
    public void subscribeUpdate() {
        nc.subscribe("update", new MessageHandler() {
            @Override
            public void onMessage(Message message) {
                logger.info("received message: {}", message.getBody());
            }
        });
    }


}
