package com.github.pakisan.podlodkajavacrew5.echomessage.api.eventmesh;

import com.github.pakisan.podlodkajavacrew5.echomessage.service.sse.MessagesBroadcaster;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.eventmesh.connector.spring.sink.EventMeshListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageController {

    private final MessagesBroadcaster messagesBroadcaster;

    @EventMeshListener
    public void onMessage(String message) {
        log.info("[message-controller], data={}", message);
        messagesBroadcaster.broadcast(message);
    }

}
