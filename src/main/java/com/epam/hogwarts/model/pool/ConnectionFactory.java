package com.epam.hogwarts.model.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    private static final String DB_URL = "db.url";
    private static final String DB_DRIVER = "db.driver";
    private static final String RESOURCE = "db.properties";

    static {
        String driverName = null;
        try (InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(RESOURCE)) {
            if (inputStream == null) {
                logger.fatal("Can't find property file by name: " + RESOURCE);
                throw new RuntimeException("fatal: can't find property file by name: " + RESOURCE);
            }
            properties.load(inputStream);
            driverName = (String) properties.get(DB_DRIVER);
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            logger.fatal("Can't register driver: " + driverName, e);
            throw new RuntimeException("fatal: can't register driver: " + driverName, e);
        } catch (IOException e) {
            logger.fatal("Can't load properties: ", e);
            throw new RuntimeException("Can't load properties: ", e);
        }
        DATABASE_URL = (String) properties.get(DB_URL);
    }

    private ConnectionFactory() {    }

    static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}