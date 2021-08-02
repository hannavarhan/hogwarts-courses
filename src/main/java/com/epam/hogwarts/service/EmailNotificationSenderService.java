package com.epam.hogwarts.service;

import com.epam.hogwarts.entity.EmailNotification;
import com.epam.hogwarts.exception.NotificationException;

@FunctionalInterface
public interface EmailNotificationSenderService {

    void sendMessage(EmailNotification emailNotification) throws NotificationException;
}
