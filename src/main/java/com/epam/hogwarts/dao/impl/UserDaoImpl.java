package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.dao.UserDao;
import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserRole;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.impl.UserMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate<User> jdbcTemplate;

    private static final String SQL_SELECT_USERS_BY_ROLE = "SELECT id_user, login, password, role_name, rating_name, " +
            "users.name, surname, email, avatar, about \n" +
            "FROM users\n" +
            "JOIN roles ON roles.id_role = users.id_role\n" +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound)\n" +
            "WHERE roles.name = ?;";

    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT id_user, login, password, role_name, rating_name, " +
            "users.name, surname, email, avatar, about \n" +
            "FROM users\n" +
            "JOIN roles ON roles.id_role = users.id_role\n" +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound)\n" +
            "WHERE login = ?;";

    private static final String SQL_SELECT_USER_BY_ID = "SELECT id_user, login, password, role_name, rating_name, " +
            "users.name, surname, email, avatar, about \n" +
            "FROM users\n" +
            "JOIN roles ON roles.id_role = users.id_role\n" +
            "JOIN rating ON users.rating IN (rating.lower_bound, rating.upper_bound)\n" +
            "WHERE id_user = ?;";

    private static final String SQL_INSERT_USER = "INSERT INTO users (login, password, id_role, rating, " +
            "users.name, surname, email, avatar, about)\n" +
            "VALUES(?, ?, \n" +
            "(SELECT id_role FROM roles WHERE role_name=?), \n" +
            "?, ?, ?, ?, ?, ?);";

    private static final String SQL_UPDATE_USER = "UPDATE users \n" +
            "SET password=?,\n" +
            "id_role=(SELECT id_role FROM roles WHERE role_name=?),\n" +
            "rating=?,\n" +
            "users.name=?,\n" +
            "surname=?,\n" +
            "email=?,\n" +
            "avatar=?,\n" +
            "about=?\n" +
            "WHERE id_user=?;";

    public UserDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        Optional<User> result = jdbcTemplate.query(SQL_SELECT_USER_BY_ID, new UserMapper(), id);
        return result;
    }

    @Override
    public Optional<User> insert(User entity) throws DaoException {
        int updatedRows = jdbcTemplate.update(SQL_INSERT_USER,
                entity.getLogin(),
                entity.getPassword(),
                entity.getRole().getTitle(),
                entity.getRatingDouble(),
                entity.getName(),
                entity.getSurname(),
                entity.getEmail(),
                entity.getAvatar(),
                entity.getAbout());
        if (updatedRows == 0) {
            return Optional.empty();
        } else {
            return Optional.of(entity);
        }
    }

    @Override
    public int update(User entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_USER,
                entity.getPassword(),
                entity.getRole().getTitle(),
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
    public List<User> findUsersByRole(UserRole userRole) throws DaoException {
        List<User> result = jdbcTemplate.queryForList(SQL_SELECT_USERS_BY_ROLE, new UserMapper(), userRole);
        return result;
    }
}
