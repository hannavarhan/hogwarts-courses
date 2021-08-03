package com.epam.hogwarts.model.service;

import com.epam.hogwarts.model.entity.TelegramNotification;
import com.epam.hogwarts.exception.NotificationException;

@FunctionalInterface
public interface TelegramNotificationSenderService {

    void sendMessage(TelegramNotification notification) throws NotificationException;
}
