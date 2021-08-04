package com.epam.hogwarts.model.service.impl;

import com.epam.hogwarts.model.dao.DaoProvider;
import com.epam.hogwarts.model.dao.UserDao;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.service.UserService;
import com.epam.hogwarts.util.PasswordEncryptor;
import com.epam.hogwarts.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final DaoProvider daoProvider = DaoProvider.getInstance();
    private static final UserDao userDao = daoProvider.getUserDao();
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public Optional<User> registerUser(User user) throws ServiceException {
        if (!UserValidator.validate(user)) {
            logger.error("User {} isn't valid", user);
            throw new ServiceException("User isn't valid");
        }
        try {
            Optional<User> result = userDao.insert(user);
            return result;
        } catch (DaoException e) {
            logger.error("Can't register user {}", user);
            throw new ServiceException("Can't register user", e);
        }
    }

    @Override
    public Optional<User> authenticate(String login, String password) throws ServiceException {
        //fixme: do we need to check is valid here or it is a tip for hacker?
        if (!UserValidator.validateLogin(login) || !UserValidator.validatePassword(password)) {
            logger.error("Login {} or password {} isn' valid", login, password);
            throw new ServiceException("Login or password isn' valid");
        }
        try {
            Optional<User> userResult = userDao.findUserByLogin(login);
            if (userResult.isPresent()) {
                User user = userResult.get();
                PasswordEncryptor encryptor = PasswordEncryptor.getInstance();
                if (encryptor.encrypt(password).equals(user.getPassword())) {
                    return userResult;
                }
            }
            return Optional.empty();
        } catch (DaoException e) {
            logger.error("Error while authenticate by login {} and password {}", login, password);
            throw new ServiceException("Error while authenticate", e);
        }
    }

    @Override
    public boolean isLoginAvailable(String login) throws ServiceException {
        try {
            Optional<User> userResult = userDao.findUserByLogin(login);
            return userResult.isEmpty();
        } catch (DaoException e) {
            logger.error("Error in isLoginAvailable with login {}", login);
            throw new ServiceException("Error while isLoginAvailable", e);
        }
    }

    @Override
    public boolean updateUser(User user) throws ServiceException {
        try {
            int updated = userDao.update(user);
            return updated > 0;
        } catch (DaoException e) {
            logger.error("Error in updateUser with login {}", user.getLogin());
            throw new ServiceException("Error while updateUser", e);
        }
    }


}
