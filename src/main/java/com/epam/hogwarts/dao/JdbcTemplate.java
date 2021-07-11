package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.AbstractEntity;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.RowMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTemplate<T extends AbstractEntity> {

    private ConnectionPool connectionPool;
    private RowMapper<T> rowMapper;

    public JdbcTemplate(ConnectionPool connectionPool, RowMapper<T> rowMapper) {
        this.connectionPool = connectionPool;
        this.rowMapper = rowMapper;
    }

    public Optional<T> query(String sql, Object... objects) throws DaoException {
        Optional<T> t;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i, objects[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            t = Optional.of(rowMapper.mapRow(resultSet));
        } catch (SQLException e) {
            throw new DaoException("Can't handle UserDao.findUserByEmail request", e);
        }
        return t;
    }

    public List<T> queryForList(String sql, Object... objects) {
        return null;
    }

    public int update(String sql, Object... objects) {
        return 0;
    }

}
