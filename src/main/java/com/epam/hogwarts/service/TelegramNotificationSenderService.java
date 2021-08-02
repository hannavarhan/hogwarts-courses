package com.epam.hogwarts.service;

import com.epam.hogwarts.entity.TelegramNotification;
import com.epam.hogwarts.exception.NotificationException;

@FunctionalInterface
public interface TelegramNotificationSenderService {

    void sendMessage(TelegramNotification notification) throws NotificationException;
}
