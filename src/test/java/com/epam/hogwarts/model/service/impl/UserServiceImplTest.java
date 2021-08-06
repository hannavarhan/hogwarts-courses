package com.epam.hogwarts.model.service.impl;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.dao.DaoProvider;
import com.epam.hogwarts.model.dao.UserDao;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.entity.UserRole;
import com.epam.hogwarts.model.entity.UserStatus;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private DaoProvider daoProvider = DaoProvider.getInstance();
    private UserDao userDao = daoProvider.getUserDao();
    private UserService userService = ServiceProvider.getInstance().getUserService();
    private User userPrototype;

    @BeforeEach
    void init() {
        userDao = mock(UserDao.class);
        userPrototype = new User.Builder()
                .setUserId(1L)
                .setLogin("test_login")
                .setPassword("test_password")
                .setEmail("test@mail.com")
                .setRole(UserRole.PUPIL)
                .setName("test_name")
                .setSurname("test_surname")
                .setStatus(UserStatus.CONFIRMED)
                .setAbout("test_about")
                .build();

    }

    @Test
    void registerUser() throws DaoException, ServiceException {
        when(userDao.insert(any())).thenReturn(Optional.ofNullable(userPrototype));
        Optional<User> registeredUser = userService.registerUser(userPrototype);
        assertEquals(registeredUser, Optional.ofNullable(userPrototype));
    }

    @Test
    void authenticate() {
    }

    @Test
    void isLoginAvailable() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getActualProfessors() {
    }
}