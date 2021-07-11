package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.UserDao;
import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserRole;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.epam.hogwarts.dao.ColumnName.USER_ID;

public class UserDaoImpl implements UserDao {

    public static final String SQL_SELECT_USERS_BY_ROLE = "SELECT id_user, login, password, roles.name, rating.name, " +
            "users.name, surname, email, avatar, about \n" +
            "FROM users\n" +
            "JOIN roles ON roles.id_role = users.id_role\n" +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound)\n" +
            "WHERE roles.name = ?;";

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public User insert(User entity) throws DaoException {
        return null;
    }

    @Override
    public User findUserByLogin(String login) throws DaoException {
        return null;
    }

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<User> findUsersByRole(UserRole userRole) throws DaoException {
        User user = null;
        try (Connection connection = connectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USERS_BY_ROLE)) {
            statement.setString(1, SQL_SELECT_USERS_BY_ROLE);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User.Builder()
                        .setUserId(resultSet.getLong(USER_ID)).build();
            }
        } catch (SQLException e) {
            throw new DaoException("Can't handle UserDao.findUserByEmail request", e);
        }
        return (List<User>) user;
    }
}
