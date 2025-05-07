package com.chatterbox.notificationservice.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Service layer responsible for interacting with Redis to store user notification data.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class RedisStorageService {

    private final RedisTemplate<String, String> redisTemplate;

    public void addNotification(String username, String message) {
        redisTemplate.opsForSet().add("username:" + username, message);
    }

    public Set<String> getNotifications(String username) {
        return redisTemplate.opsForSet().members("username:" + username);
    }

    // Dev-only debugging method
    public Map<String, Set<String>> getAll() {
        Map<String, Set<String>> allData = new HashMap<>();
        Set<String> keys = redisTemplate.keys("*");
        if (keys.isEmpty()) {
            log.info("No keys found in notification redis database.");
            return null;
        }
        keys.forEach(key -> {
            Set<String> members = redisTemplate.opsForSet().members(key);
            log.info("Key: {}, Members: {}", key, members);
            allData.put(key, members);
        });
        return allData;
    }

    // debut / admin only
    public void deleteAll() {
        redisTemplate.delete(redisTemplate.keys("*"));
    }
}
