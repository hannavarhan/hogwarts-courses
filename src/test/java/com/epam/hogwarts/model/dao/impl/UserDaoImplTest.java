package com.epam.hogwarts.model.dao.impl;

import com.epam.hogwarts.dao.UserDao;
import com.epam.hogwarts.dao.impl.UserDaoImpl;
import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserRole;
import com.epam.hogwarts.exception.DaoException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserDaoImplTest {

    UserDao userDao;

    @BeforeTest
    public void init() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testFindById() throws DaoException {
        User actual = new User.Builder()
                .setUserId(1L)
                .setLogin("algl")
                .setPassword("2510")
                .setRole(UserRole.ADMIN)
                .setRating("muggle")
                .setName("Илья")
                .setSurname("Власов")
                .setAbout("я администратор(")
                .build();
        User expected = userDao.findById(1L).get();
        Assert.assertEquals(actual.getName(), expected.getName());
    }
}
