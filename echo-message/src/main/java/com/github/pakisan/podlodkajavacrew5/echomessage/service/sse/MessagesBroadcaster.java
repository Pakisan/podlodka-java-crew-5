package com.github.pakisan.podlodkajavacrew5.echomessage.service.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.LinkedList;
import java.util.UUID;

@Slf4j
@Service
public class MessagesBroadcaster {

    private final LinkedList<SseEmitter> subscribers = new LinkedList<>();

    public void subscribe(SseEmitter subscriber) {
        subscribers.add(subscriber);
        log.info("New subscription");
    }

    public void broadcast(Object message) {
        log.info("broadcasting message to next number of subscribers: {}", subscribers.size());
        subscribers.forEach(subscriber -> {
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(message)
                        .id(UUID.randomUUID().toString())
                        .name("message");

                subscriber.send(event);
                log.info("Message was sent: {}", message);
            } catch (Exception ex) {
                subscribers.remove(subscriber);
            }
        });
    }

}
