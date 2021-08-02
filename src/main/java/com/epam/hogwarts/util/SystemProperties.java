package com.epam.hogwarts.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
    private static final String RESOURCE = "system.properties";
    private static final Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(SystemProperties.class);
    private static final String PAGE_LIMIT_PROPERTY = "page.limit";

    private static final int PAGE_LIMIT;
    private static final int DEFAULT_PAGE_LIMIT = 20;

    private SystemProperties() {}

    static {
        String driverName = null;
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
        PAGE_LIMIT = properties.get(PAGE_LIMIT_PROPERTY) == null ?
                DEFAULT_PAGE_LIMIT : (int) properties.get(PAGE_LIMIT_PROPERTY);
    }

    public static int getPageLimit() {
        return PAGE_LIMIT;
    }
}
