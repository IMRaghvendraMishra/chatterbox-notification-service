package com.chatterbox.notificationservice.controller;

import com.chatterbox.notificationservice.dto.NotificationRequest;
import com.chatterbox.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Endpoint to trigger a notification manually (for local testing/debugging).
     */
    @PostMapping
    public String sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return "Notification processed";
    }

    /**
     * Get all notifications for a given username.
     */
    @GetMapping("/{username}")
    public Set<String> getNotifications(@PathVariable String username) {
        return notificationService.getNotifications(username);
    }

    /**
     * Get all notifications mapped by username.
     */
    @GetMapping("/all")
    public Map<String, Set<String>> getAllNotifications() {
        return notificationService.getAll();
    }

    /**
     * Delete all notifications (admin use).
     */
    @DeleteMapping("/admin/all")
    public String deleteAllNotifications() {
        notificationService.deleteAll();
        return "All notifications deleted";
    }
}
