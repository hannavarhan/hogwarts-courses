package com.epam.hogwarts.service;

import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.exception.ServiceException;

import java.util.Optional;

public interface UserService {

    Optional<User> registerUser(User user) throws ServiceException;

    Optional<User> authenticate(String login, String password) throws ServiceException;

    boolean isLoginAvailable(String login) throws ServiceException;

}
