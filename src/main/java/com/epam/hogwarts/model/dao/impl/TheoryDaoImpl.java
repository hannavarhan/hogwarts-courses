package com.epam.hogwarts.model.dao.impl;

import com.epam.hogwarts.model.dao.JdbcTemplate;
import com.epam.hogwarts.model.dao.TheoryDao;
import com.epam.hogwarts.model.entity.Theory;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.mapper.impl.TheoryMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class TheoryDaoImpl implements TheoryDao {
    private static final TheoryDaoImpl instance = new TheoryDaoImpl();

    private static final String SQL_SELECT_THEORY_BY_ID = "SELECT id_theory, text, number, id_course " +
            "FROM hogwarts_courses.theory " +
            "WHERE id_theory=?;";

    private static final String SQL_INSERT_THEORY = "INSERT INTO hogwarts_courses.theory " +
            "(text, number, id_course) " +
            "VALUES (?, ?, ?);";

    public static final String SQL_UPDATE_THEORY = "UPDATE hogwarts_courses.theory SET " +
            "text=?, " +
            "number=?, " +
            "id_course=? " +
            "WHERE id_theory=?;";

    private static final String SQL_SELECT_THEORY_BY_COURSE_ID = "SELECT id_theory, text, number, id_course " +
            "FROM hogwarts_courses.theory " +
            "WHERE id_course=?;";

    private JdbcTemplate<Theory> jdbcTemplate;

    private TheoryDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static TheoryDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Theory> findById(Long id) throws DaoException {
        Optional<Theory> result = jdbcTemplate.query(SQL_SELECT_THEORY_BY_ID, new TheoryMapper(), id);
        return result;
    }

    @Override
    public Optional<Theory> insert(Theory entity) throws DaoException {
        long theoryId = jdbcTemplate.insert(SQL_INSERT_THEORY,
                entity.getText(),
                entity.getNumber(),
                entity.getCourseId());
        entity.setEntityId(theoryId);
        return Optional.of(entity);
    }

    @Override
    public int update(Theory entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_THEORY,
                entity.getText(),
                entity.getNumber(),
                entity.getCourseId(),
                entity.getEntityId());
        return result;
    }

    @Override
    public List<Theory> findByCoursesId(Long courseId) throws DaoException {
        List<Theory> result = jdbcTemplate.queryForList(SQL_SELECT_THEORY_BY_COURSE_ID, new TheoryMapper(), courseId);
        return result;
    }
}
