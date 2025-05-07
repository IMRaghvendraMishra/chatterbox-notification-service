package com.chatterbox.notificationservice.messaging;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PostEventConsumer {

    @KafkaListener(topics = "${spring.kafka.post-events-topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumePostEvent(String message) {
        log.info("Received post event from Kafka: {}", message);
        // TODO: integrate who should be notified about this post. follower?
        // for all the followers do the following:
        // Hi follower1.username, There is new post from message.userId.username (rest api call from user service to
        // read user name
    }
}
