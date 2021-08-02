package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.dao.QuestionDao;
import com.epam.hogwarts.entity.Question;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.impl.QuestionMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl implements QuestionDao {

    private static final QuestionDaoImpl instance = new QuestionDaoImpl();


    private static final String SQL_SELECT_QUESTION_BY_ID = "SELECT id_question, text, number, id_course " +
            "FROM hogwarts_courses.questions " +
            "WHERE id_question=?;";

    private static final String SQL_INSERT_QUESTION = "INSERT INTO hogwarts_courses.questions " +
            "(text, number, id_course) " +
            "VALUES (?, ?, ?);";

    public static final String SQL_UPDATE_QUESTION = "UPDATE hogwarts_courses.questions SET " +
            "text=?, " +
            "number=?, " +
            "id_course=? " +
            "WHERE id_question=?;";

    private static final String SQL_SELECT_QUESTION_BY_COURSE_ID = "SELECT id_question, text, number, id_course " +
            "FROM hogwarts_courses.questions " +
            "WHERE id_course=?;";

    private JdbcTemplate<Question> jdbcTemplate;

    private QuestionDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static QuestionDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Question> findById(Long id) throws DaoException {
        Optional<Question> result = jdbcTemplate.query(SQL_SELECT_QUESTION_BY_ID, new QuestionMapper(), id);
        return result;
    }

    @Override
    public Optional<Question> insert(Question entity) throws DaoException {
        long questionId = jdbcTemplate.insert(SQL_INSERT_QUESTION,
                entity.getText(),
                entity.getNumber(),
                entity.getCourseId());
        entity.setEntityId(questionId);
        return Optional.of(entity);
    }

    @Override
    public int update(Question entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_QUESTION,
                entity.getText(),
                entity.getNumber(),
                entity.getCourseId(),
                entity.getEntityId());
        return result;
    }

    @Override
    public List<Question> findByCourseId(Long courseId) throws DaoException {
        List<Question> result = jdbcTemplate.queryForList(SQL_SELECT_QUESTION_BY_COURSE_ID, new QuestionMapper(), courseId);
        return result;
    }
}
