package com.epam.hogwarts.model.dao.impl;

import com.epam.hogwarts.model.dao.JdbcTemplate;
import com.epam.hogwarts.model.dao.UserDao;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.entity.UserRole;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.entity.UserStatus;
import com.epam.hogwarts.model.mapper.impl.UserMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl instance = new UserDaoImpl();

    private static final String SQL_SELECT_ACTUAL_USERS_BY_ROLE = "SELECT id_user, login, password, role_name, status, rating_name, " +
            "users.name, surname, email, avatar, about " +
            "FROM users " +
            "JOIN roles ON roles.id_role = users.id_role " +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound) " +
            "WHERE roles.role_name = ? && users.status != \"not_actual\";";

    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT id_user, login, password, role_name, status, rating_name, " +
            "users.name, surname, email, avatar, about " +
            "FROM users " +
            "JOIN roles ON roles.id_role = users.id_role " +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound) " +
            "WHERE login = ?;";

    private static final String SQL_SELECT_USER_BY_ID = "SELECT id_user, login, password, role_name, status, rating_name, " +
            "users.name, surname, email, avatar, about " +
            "FROM users " +
            "JOIN roles ON roles.id_role = users.id_role " +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound) " +
            "WHERE id_user = ?;";

    private static final String SQL_INSERT_USER = "INSERT INTO users (login, password, id_role, rating, " +
            "users.name, surname, email, avatar, about) " +
            "VALUES(?, ?,  " +
            "(SELECT id_role FROM roles WHERE role_name=?),  " +
            "?, ?, ?, ?, ?, ?);";

    private static final String SQL_UPDATE_USER = "UPDATE users  " +
            "SET password=?, " +
            "id_role=(SELECT id_role FROM roles WHERE role_name=?), " +
            "status=?, " +
            "rating=?, " +
            "users.name=?, " +
            "surname=?, " +
            "email=?, " +
            "avatar=?, " +
            "about=? " +
            "WHERE id_user=?;";

    private static final String SQL_UPDATE_STATUS = "UPDATE users " +
            "SET status=? " +
            "WHERE id_user=?;";

    private JdbcTemplate<User> jdbcTemplate;

    private UserDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        Optional<User> result = jdbcTemplate.query(SQL_SELECT_USER_BY_ID, new UserMapper(), id);
        return result;
    }

    @Override
    public Optional<User> insert(User entity) throws DaoException {
        long userId = jdbcTemplate.insert(SQL_INSERT_USER,
                entity.getLogin(),
                entity.getPassword(),
                entity.getRole().getTitle(),
                entity.getRatingDouble(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getAvatar(),
                entity.getAbout());
        entity.setEntityId(userId);
        return Optional.of(entity);
    }

    @Override
    public int update(User entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_USER,
                entity.getPassword(),
                entity.getRole().getTitle(),
                entity.getStatus().toString().toLowerCase(),
                entity.getRatingDouble(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getAvatar(),
                entity.getAbout(),
                entity.getEntityId());
        return result;
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        Optional<User> result = jdbcTemplate.query(SQL_SELECT_USER_BY_LOGIN, new UserMapper(), login);
        return result;
    }

    @Override
    public List<User> findActualUsersByRole(UserRole userRole) throws DaoException {
        List<User> result = jdbcTemplate.queryForList(SQL_SELECT_ACTUAL_USERS_BY_ROLE, new UserMapper(),
                userRole.toString().toLowerCase());
        return result;
    }

    @Override
    public boolean updateUserStatus(long userId, UserStatus status) throws DaoException {
        int updatedRows = jdbcTemplate.update(SQL_UPDATE_STATUS, status.toString().toLowerCase(), userId);
        return updatedRows > 0;
    }
}
