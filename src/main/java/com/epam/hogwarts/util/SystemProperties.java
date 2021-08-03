package com.epam.hogwarts.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
    private static final String RESOURCE = "project.properties";
    private static final Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(SystemProperties.class);
    private static final String PAGE_LIMIT_PROPERTY = "page.limit";
    private static final String NOTIFICATION_ATTEMPT_PROPERTY = "notification.attempt";

    private static final int PAGE_LIMIT;
    private static final int NOTIFICATION_ATTEMPTS;

    private static final int DEFAULT_PAGE_LIMIT = 20;

    private SystemProperties() {}

    static {
        try (InputStream inputStream = SystemProperties.class.getClassLoader().getResourceAsStream(RESOURCE)) {
            if (inputStream == null) {
                logger.fatal("Can't find property file by name: " + RESOURCE);
                throw new RuntimeException("fatal: can't find property file by name: " + RESOURCE);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            logger.fatal("Can't load properties: ", e);
            throw new RuntimeException("Can't load properties: ", e);
        }
        String pageLimitPropValue = (String) properties.get(PAGE_LIMIT_PROPERTY);
        String notificationAttemptPropValue = (String) properties.get(NOTIFICATION_ATTEMPT_PROPERTY);
        PAGE_LIMIT = pageLimitPropValue == null ?
                DEFAULT_PAGE_LIMIT : Integer.parseInt(pageLimitPropValue);
        NOTIFICATION_ATTEMPTS = Integer.parseInt(notificationAttemptPropValue);

    }

    public static int getPageLimit() {
        return PAGE_LIMIT;
    }

    public static int getNotificationAttempts() {
        return NOTIFICATION_ATTEMPTS;
    }
}
