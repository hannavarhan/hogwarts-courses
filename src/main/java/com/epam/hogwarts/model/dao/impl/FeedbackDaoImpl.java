package com.epam.hogwarts.model.dao.impl;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.dao.FeedbackDao;
import com.epam.hogwarts.model.dao.JdbcTemplate;
import com.epam.hogwarts.model.entity.Feedback;
import com.epam.hogwarts.model.mapper.impl.FeedbackMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class FeedbackDaoImpl implements FeedbackDao {

    private static final FeedbackDaoImpl instance = new FeedbackDaoImpl();

    private static final String SQL_INSERT = "INSERT INTO hogwarts_courses.feedback " +
            "(comment, estimator, id_course, id_pupil) " +
            "VALUES " +
            "(?,?,?,?);";

    private static final String SQL_SELECT_BY_COURSE_ID = "SELECT feedback.id_feedback, " +
            "feedback.comment, " +
            "feedback.estimator, " +
            "feedback.id_course, " +
            "feedback.id_pupil " +
            "FROM hogwarts_courses.feedback WHERE id_course=?;";

    private static final String SQL_SELECT_COUNT_BY_COURSE_ID = "SELECT count(*) count " +
            "FROM hogwarts_courses.feedback " +
            "WHERE id_course=?;";

    private JdbcTemplate<Feedback> jdbcTemplate;

    private FeedbackDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static FeedbackDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Feedback> findById(Long id) throws DaoException {
        throw new UnsupportedOperationException("findById feedback");
    }

    @Override
    public Optional<Feedback> insert(Feedback entity) throws DaoException {
        long result = jdbcTemplate.insert(SQL_INSERT,
                entity.getComment(),
                entity.getEstimator(),
                entity.getCourseId(),
                entity.getPupilId());
        entity.setEntityId(result);
        return Optional.of(entity);
    }

    @Override
    public int update(Feedback entity) throws DaoException {
        throw new UnsupportedOperationException("update feedback");
    }

    @Override
    public List<Feedback> findByCourse(long courseId) throws DaoException {
        List<Feedback> result = jdbcTemplate.queryForList(SQL_SELECT_BY_COURSE_ID, new FeedbackMapper(), courseId);
        return result;
    }

    @Override
    public int countByCourse(long courseId) throws DaoException {
        int result = jdbcTemplate.count(SQL_SELECT_COUNT_BY_COURSE_ID, courseId);
        return result;
    }
}
