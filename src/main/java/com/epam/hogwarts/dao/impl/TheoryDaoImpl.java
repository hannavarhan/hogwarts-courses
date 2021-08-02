package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.dao.TheoryDao;
import com.epam.hogwarts.entity.Course;
import com.epam.hogwarts.entity.Theory;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class TheoryDaoImpl implements TheoryDao {
    private static final TheoryDaoImpl instance = new TheoryDaoImpl();

    public static TheoryDaoImpl getInstance() {
        return instance;
    }
    private JdbcTemplate<Course> jdbcTemplate;

    private TheoryDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    @Override
    public Optional<Theory> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Theory> insert(Theory entity) throws DaoException {
        return Optional.empty();
    }

    @Override
    public int update(Theory entity) throws DaoException {
        return 0;
    }

    @Override
    public List<Theory> findByCoursesId(Long courseId) throws DaoException {
        return null;
    }
}
