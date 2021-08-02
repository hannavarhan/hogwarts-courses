package com.epam.hogwarts.service.impl;

import com.epam.hogwarts.entity.TelegramNotification;
import com.epam.hogwarts.exception.NotificationException;
import com.epam.hogwarts.model.pool.TelegramURLConnectionFactory;
import com.epam.hogwarts.service.TelegramNotificationSenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URLConnection;

public class TelegramNotificationSenderServiceImpl implements TelegramNotificationSenderService {

    private static Logger logger = LogManager.getLogger(TelegramNotificationSenderServiceImpl.class);

    @Override
    public void sendMessage(TelegramNotification telegramNotification) throws NotificationException {
        int attempt = 1;
        while (telegramNotification.getAllowableAttempts() > attempt && !telegramNotification.isSend()) {
            try {
                send(telegramNotification);
            } catch (NotificationException e) {
                logger.error("Error while sending telegram message. {} attempt. Trying to resend...", attempt);
                attempt++;
            }
        }
        if (!telegramNotification.isSend()) {
            logger.error("Error while sending telegram message. {} attempt ended", attempt);
            throw new NotificationException("Error while sending telegram message");
        }
    }

    private void send(TelegramNotification telegramNotification) throws NotificationException {
        try {
            URLConnection connection = TelegramURLConnectionFactory.createConnection(telegramNotification.toString());
            StringBuilder sb = new StringBuilder();
            InputStream is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            String response = sb.toString();
            telegramNotification.setSend(true);
            logger.info("Notification to telegram was send. Telegram answer is {}", response);
        } catch (IOException e) {
            logger.error("IOException in send telegram message: {}", e.getMessage());
            throw new NotificationException("Exception in send telegram message", e);
        }
    }

}
