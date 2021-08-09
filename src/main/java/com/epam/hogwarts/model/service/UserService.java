package com.epam.hogwarts.model.service;

import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> registerUser(User user) throws ServiceException;

    Optional<User> authenticate(String login, String password) throws ServiceException;

    boolean isLoginAvailable(String login) throws ServiceException;

    boolean updateUser(User user) throws ServiceException;

    boolean deleteUser(long userId) throws ServiceException;

    List<User> getActualProfessors() throws ServiceException;

    Optional<User> findUserById(long userId) throws ServiceException;

}
