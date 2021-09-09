package org.example.service;

import nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Service
public class PublishService {

    private static final Logger logger = LoggerFactory.getLogger(PublishService.class);

    @Autowired
    private Nats nc;

    public void publish(String name) {
        logger.info("the message:{} will be send", name);
        // simple sync message
        nc.publish("hello", "Hello:" + name);
    }
}
