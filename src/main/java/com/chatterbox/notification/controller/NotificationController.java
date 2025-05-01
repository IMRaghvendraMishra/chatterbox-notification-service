package com.chatterbox.notification.controller;

import com.chatterbox.notification.dto.NotificationRequest;
import com.chatterbox.notification.model.Notification;
import com.chatterbox.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@NoArgsConstructor
@AllArgsConstructor
public class NotificationController {

    @Autowired private NotificationService notificationService;

    @PostMapping
    public String notify(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return "Notification processed";
    }

    @GetMapping("/{userId}")
    public List<Notification> getNotifications(@PathVariable String userId) {
        return notificationService.getNotificationsForUser(userId);
    }
}
