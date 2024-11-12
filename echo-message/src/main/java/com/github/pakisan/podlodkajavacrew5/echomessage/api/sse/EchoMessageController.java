package com.github.pakisan.podlodkajavacrew5.echomessage.api.sse;

import com.github.pakisan.podlodkajavacrew5.echomessage.service.sse.MessagesBroadcaster;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/echo")
@RequiredArgsConstructor
public class EchoMessageController {

    private final MessagesBroadcaster messagesBroadcaster;

    @GetMapping
    public SseEmitter echo() {
        SseEmitter emitter = new SseEmitter(600_000L); // 20 minutes
        messagesBroadcaster.subscribe(emitter);

        return emitter;
    }

}
