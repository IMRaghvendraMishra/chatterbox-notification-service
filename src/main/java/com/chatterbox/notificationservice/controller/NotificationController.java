package com.chatterbox.notificationservice.controller;

import com.chatterbox.notificationservice.dto.NotificationRequest;
import com.chatterbox.notificationservice.model.Notification;
import com.chatterbox.notificationservice.service.NotificationService;
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
