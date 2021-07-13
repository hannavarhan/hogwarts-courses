package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.AbstractEntity;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.RowMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplate<T extends AbstractEntity> {

    private ConnectionPool connectionPool;

    public JdbcTemplate(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Optional<T> query(String sql, RowMapper<T> rowMapper, Object... objects) throws DaoException {
        Optional<T> result;
        try (Connection connection = connectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            setObjectsToStatement(statement, objects);
            ResultSet resultSet = statement.executeQuery();
            result = Optional.of(rowMapper.mapRow(resultSet));
        } catch (SQLException e) {
            throw new DaoException("Can't handle UserDao.query request", e);
        }
        return result;
    }

    public List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... objects) throws DaoException {
        List<T> result = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setObjectsToStatement(statement, objects);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = rowMapper.mapRow(resultSet);
                result.add(entity);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't handle UserDao.queryForList request", e);
        }
        return result;
    }

    public int update(String sql, Object... objects) throws DaoException {
        int result;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setObjectsToStatement(statement, objects);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't handle UserDao.update request", e);
        }
        return result;
    }

    private void setObjectsToStatement(PreparedStatement statement, Object... objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            statement.setObject(i, objects[i]);
        }
    }

}
