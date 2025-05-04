package com.chatterbox.notificationservie.service;

import com.chatterbox.notificationservie.dto.NotificationRequest;
import com.chatterbox.notificationservie.model.Notification;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class NotificationService {

    private final Map<String, List<Notification>> notifications = new HashMap<>();

    public void sendNotification(NotificationRequest request) {
        notifications
                .computeIfAbsent(request.getUserId(), k -> new ArrayList<>())
                .add(new Notification(request.getUserId(), request.getMessage()));
        System.out.println("Notification sent: " + request.getMessage());
    }

    public List<Notification> getNotificationsForUser(String userId) {
        Notification notification1 = new Notification(userId, "message");
        Notification notification2 = new Notification(userId, "message");
        Notification notification3 = new Notification(userId, "message");
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
        return notifications.getOrDefault(userId, notificationList);
    }
}