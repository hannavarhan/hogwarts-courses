package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.model.entity.AbstractEntity;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.mapper.RowMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplate<T extends AbstractEntity> {

    private ConnectionPool connectionPool;

    public JdbcTemplate(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Optional<T> query(String sql, RowMapper<T> rowMapper, Object... objects) throws DaoException {
        Optional<T> result = Optional.empty();
        try (Connection connection = connectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            setObjectsToStatement(statement, objects);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = Optional.of(rowMapper.mapRow(resultSet));
            }
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
            throw new DaoException("Can't handle queryForList request", e);
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
            throw new DaoException("Can't handle update request", e);
        }
        return result;
    }

    public long insert(String sql, Object... objects) throws DaoException {
        long result = 0;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setObjectsToStatement(statement, objects);
            int updatedRows = statement.executeUpdate();
            if (updatedRows == 0) {
                throw new DaoException("Couldn't insert");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't handle update request", e);
        }
        return result;
    }

    public int count(String sql, Object... objects) throws DaoException {
        int result = 0;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            setObjectsToStatement(statement, objects);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't handle count request", e);
        }
        return result;
    }

    private void setObjectsToStatement(PreparedStatement statement, Object... objects) throws SQLException {
        for (int i = 0; i < objects.length; i++) {
            statement.setObject(i+1, objects[i]);
        }
    }

}
