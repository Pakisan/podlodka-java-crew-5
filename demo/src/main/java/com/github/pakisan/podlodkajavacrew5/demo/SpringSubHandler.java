package com.github.pakisan.podlodkajavacrew5.demo;

import org.apache.eventmesh.connector.spring.sink.EventMeshListener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SpringSubHandler {

    @EventMeshListener
    public void onMessage(String message) {
        log.info("[SPRING--MESSAGE-RECEIVED], data={}", message);
    }

}
