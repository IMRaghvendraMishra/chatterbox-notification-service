package com.chatterbox.notificationservice.service;

import com.chatterbox.notificationservice.dto.NotificationRequest;
import com.chatterbox.notificationservice.storage.RedisStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
* Core business service handling follower relationships.
* Validates users, updates Redis sets, and publishes events to Kafka.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationService {

    private final RedisStorageService redisStorageService;

    public void sendNotification(NotificationRequest request) {
        redisStorageService.addNotification(request.getUsername(), request.getMessage());
        log.info("Notification sent: {}", request.getMessage());
    }

    // Dev-only debugging method
    public Set<String> getNotifications(String username) {
        return redisStorageService.getNotifications(username);
    }

    // Dev-only debugging method
    public Map<String, Set<String>> getAll() {
        return redisStorageService.getAll();
    }

    public String deleteAll() {
        redisStorageService.deleteAll();
        return "All notifications deleted";
    }
}