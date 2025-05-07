package com.chatterbox.notificationservice.messaging;

import com.chatterbox.notificationservice.messaging.event.NotificationEvent;
import com.chatterbox.notificationservice.util.ObjectJsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
/**
 * Inform the user about their new notification
 */
public class NotificationEventConsumer {

    @Autowired private ObjectJsonMapper mapper;

    @KafkaListener(topics = "${spring.kafka.notification-events-topic-name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeFollowEvent(String message) {
        // log.info("Received follow event from Kafka: {}", message);
        NotificationEvent event = mapper.jsonToNotificationEvent(message);
        log.info(event.message());
    }
}
