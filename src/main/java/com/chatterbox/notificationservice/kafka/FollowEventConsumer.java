package com.chatterbox.notificationservice.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
/**
 * Inform the user about their new follower
 */
public class FollowEventConsumer {
// TODO: end to end testing
   // @KafkaListener(topics = "${spring.kafka.follow-service-topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeFollowEvent(String message) {
        log.info("Received follow event from Kafka: {}", message);
        // message: Hi user, xyz started following you
    }
}
