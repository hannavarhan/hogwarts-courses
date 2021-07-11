package com.epam.hogwarts.model.pool;

import org.testng.annotations.Test;

import java.sql.SQLException;

public class ConnectionFactoryTest {

    @Test(expectedExceptions = ExceptionInInitializerError.class)
    public void testConnectionFactory() throws SQLException {
        ConnectionFactory.createConnection();
    }

}
