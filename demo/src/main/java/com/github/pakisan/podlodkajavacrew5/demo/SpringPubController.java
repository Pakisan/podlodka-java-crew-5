package com.github.pakisan.podlodkajavacrew5.demo;

import lombok.RequiredArgsConstructor;
import org.apache.eventmesh.common.utils.JsonUtils;
import org.apache.eventmesh.connector.spring.source.connector.SpringSourceConnector;
//import org.apache.eventmesh.openconnect.offsetmgmt.api.callback.SendExceptionContext;
//import org.apache.eventmesh.openconnect.offsetmgmt.api.callback.SendMessageCallback;
//import org.apache.eventmesh.openconnect.offsetmgmt.api.callback.SendResult;

import java.util.HashMap;
import java.util.Map;

import org.apache.eventmesh.openconnect.api.callback.SendExcepionContext;
import org.apache.eventmesh.openconnect.api.callback.SendMessageCallback;
import org.apache.eventmesh.openconnect.api.callback.SendResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/spring")
public class SpringPubController {

    private final SpringSourceConnector springSourceConnector;

    @RequestMapping("/pub")
    public String publish() {
        final Map<String, String> content = new HashMap<>();
        content.put("content", "testSpringPublishMessage");
        springSourceConnector.send(JsonUtils.toJSONString(content), new SendMessageCallback() {

            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("Spring source worker send message to EventMesh success! msgId={}, topic={}",
                        sendResult.getMessageId(), sendResult.getTopic());
            }

            @Override
            public void onException(SendExcepionContext sendExcepionContext) {
                log.info("Spring source worker send message to EventMesh failed!", sendExcepionContext.getCause());
            }

        });

        return "success!";
    }

}
