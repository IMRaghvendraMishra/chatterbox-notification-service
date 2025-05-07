package com.chatterbox.notificationservice.controller;

import com.chatterbox.notificationservice.dto.NotificationRequest;
import com.chatterbox.notificationservice.dto.Notification;
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

    /**
     * This is for local testing. Actual notifications will be processed by event consumers
     */
    @PostMapping
    public String notify(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return "Notification processed";
    }

    @GetMapping("/{username}")
    public List<Notification> getNotifications(@PathVariable String username) {
        return notificationService.getNotifications(username);
    }

    @DeleteMapping("/admin/deleteAll")
    public String deleteAll() {
        notificationService.deleteAll();
        return "All notifications deleted";
    }
}
