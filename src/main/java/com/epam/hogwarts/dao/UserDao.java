package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserRole;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {

    Optional<User> findUserByLogin(String login) throws DaoException;

    List<User> findUsersByRole(UserRole userRole) throws DaoException;
}
