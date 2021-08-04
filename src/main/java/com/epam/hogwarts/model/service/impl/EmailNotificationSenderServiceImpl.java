package com.epam.hogwarts.model.service.impl;

import com.epam.hogwarts.model.entity.EmailNotification;
import com.epam.hogwarts.exception.NotificationException;
import com.epam.hogwarts.model.pool.EmailSessionFactory;
import com.epam.hogwarts.model.service.EmailNotificationSenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailNotificationSenderServiceImpl implements EmailNotificationSenderService {

    private static Logger logger = LogManager.getLogger(EmailNotificationSenderServiceImpl.class);
    private static final Properties properties = new Properties();
    private static final String RESOURCE = "notification.properties";

    @Override
    public void sendMessage(EmailNotification notification) throws NotificationException {
        loadProperties();

        Session session = EmailSessionFactory.createSession(properties);
        Message message = new MimeMessage(session);

        String recipientEmail = notification.getEmail();
        String subject = notification.getSubject();
        String content = notification.getText();
        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setContent(content, "text/plain; charset=UTF-8");
        } catch (MessagingException e) {
            logger.error("Error while setting email message attributes: {}, {}, {}",
                    recipientEmail, subject, content);
            throw new NotificationException("Error while setting email message attributes");
        }

        int attempt = 1;
        while (notification.getAllowableAttempts() > attempt && !notification.isSend()) {
            try {
                Transport.send(message);
                notification.setSend(true);
            } catch (MessagingException e) {
                logger.error("Error while sending email message. {} attempt. Trying to resend...", attempt);
                attempt++;
            }
        }
        if (notification.isSend()) {
            logger.info("Email notification {} was send", notification);
        } else {
            logger.error("Error while sending email message. {} attempt ended", attempt);
            throw new NotificationException("Error while sending telegram message");
        }
    }

    private void loadProperties() {
        try (InputStream inputStream = EmailSessionFactory.class.getClassLoader()
                .getResourceAsStream(RESOURCE)) {
            if (inputStream == null) {
                logger.fatal("Can't find property file by name: " + RESOURCE);
                throw new RuntimeException("fatal: can't find property file by name: " + RESOURCE);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            logger.fatal("Can't load properties: ", e);
            throw new RuntimeException("Can't load properties: ", e);
        }
    }

}
