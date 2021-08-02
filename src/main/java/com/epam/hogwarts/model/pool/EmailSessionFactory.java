package com.epam.hogwarts.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EmailSessionFactory {

    private static Logger logger = LogManager.getLogger(EmailSessionFactory.class);
    private static final String AUTH_PROPERTY = "mail.smtp.auth";
    private static final String START_PROPERTY = "mail.smtp.starttls.enable";
    private static final String HOST_PROPERTY = "mail.smtp.host";
    private static final String PORT_PROPERTY = "mail.smtp.port";
    private static final String SMTP_PROPERTY = "mail.smtp.ssl.trust";
    private static final String USERNAME_PROPERTY = "mail.user.name";
    private static final String PASSWORD_PROPERTY = "mail.user.password";

    private EmailSessionFactory() {}

    public static Session createSession(Properties properties) {
        String username = properties.getProperty(USERNAME_PROPERTY);
        String password = properties.getProperty(PASSWORD_PROPERTY);
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }
}
