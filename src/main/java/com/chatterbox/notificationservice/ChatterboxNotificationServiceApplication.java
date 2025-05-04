package com.chatterbox.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ChatterboxNotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatterboxNotificationServiceApplication.class, args);
    }
}