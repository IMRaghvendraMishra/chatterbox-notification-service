package com.chatterbox.notificationservice.service;

import com.chatterbox.notificationservice.dto.NotificationRequest;
import com.chatterbox.notificationservice.dto.Notification;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class NotificationService {

    private final Map<String, List<Notification>> notifications = new HashMap<>();

    public void sendNotification(NotificationRequest request) {
        notifications
                .computeIfAbsent(request.getUsername(), k -> new ArrayList<>())
                .add(new Notification(request.getUsername(), request.getMessage()));
        System.out.println("Notification sent: " + request.getMessage());
    }

    public List<Notification> getNotifications(String username) {
        Notification notification1 = new Notification(username, "message");
        Notification notification2 = new Notification(username, "message");
        Notification notification3 = new Notification(username, "message");
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
        return notifications.getOrDefault(username, notificationList);
    }

    public void deleteAll() {

    }
}