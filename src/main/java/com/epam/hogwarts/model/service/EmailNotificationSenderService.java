package com.epam.hogwarts.model.service;

import com.epam.hogwarts.model.entity.EmailNotification;
import com.epam.hogwarts.exception.NotificationException;

@FunctionalInterface
public interface EmailNotificationSenderService {

    void sendMessage(EmailNotification emailNotification) throws NotificationException;
}
