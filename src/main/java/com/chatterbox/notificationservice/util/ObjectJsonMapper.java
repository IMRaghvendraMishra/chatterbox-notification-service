package com.chatterbox.notificationservice.util;


import com.chatterbox.notificationservice.messaging.event.NotificationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Utility class for serializing and deserializing JSON using Jackson.
 */
@Component
@AllArgsConstructor
@Slf4j
public class ObjectJsonMapper {

    private final ObjectMapper objectMapper;

    public NotificationEvent jsonToNotificationEvent(String json) {
        try {
            return objectMapper.readValue(json, NotificationEvent.class);
        } catch (JsonProcessingException e) {
            log.error("Unable to parse JSON to User object", e);
            return null;
        }
    }
}
