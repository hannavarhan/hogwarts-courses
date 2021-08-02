package com.epam.hogwarts.dao.impl;

import com.epam.hogwarts.dao.AnswerDao;
import com.epam.hogwarts.dao.JdbcTemplate;
import com.epam.hogwarts.entity.Answer;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.mapper.impl.AnswerMapper;
import com.epam.hogwarts.model.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

public class AnswerDaoImpl implements AnswerDao {

    private static final AnswerDaoImpl instance = new AnswerDaoImpl();

    private static final String SQL_SELECT_ANSWER_BY_ID = "SELECT id_answer, id_question, answer, is_correct " +
            "FROM hogwarts_courses.answers " +
            "WHERE id_answer=?;";

    private static final String SQL_INSERT_ANSWER = "INSERT INTO hogwarts_courses.answers " +
            "(id_question, answer, is_correct) " +
            "VALUES (?, ?, ?);";

    private static final String SQL_UPDATE_ANSWER = "UPDATE hogwarts_courses.answers SET " +
            "id_question=?, " +
            "answer=?, " +
            "is_correct=? " +
            "WHERE id_answer=?;";

    private static final String SQL_SELECT_ANSWER_BY_QUESTION_ID = "SELECT id_answer, id_question, answer, is_correct " +
            "FROM hogwarts_courses.answers " +
            "WHERE id_question=?;";

    private JdbcTemplate<Answer> jdbcTemplate;

    private AnswerDaoImpl() {
        jdbcTemplate = new JdbcTemplate<>(ConnectionPool.getInstance());
    }

    public static AnswerDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Answer> findById(Long id) throws DaoException {
        Optional<Answer> result = jdbcTemplate.query(SQL_SELECT_ANSWER_BY_ID, new AnswerMapper(), id);
        return result;
    }

    @Override
    public Optional<Answer> insert(Answer entity) throws DaoException {
        long answerId = jdbcTemplate.insert(SQL_INSERT_ANSWER,
                entity.getQuestionId(),
                entity.getText(),
                entity.isCorrect());
        entity.setEntityId(answerId);
        return Optional.of(entity);
    }

    @Override
    public int update(Answer entity) throws DaoException {
        int result = jdbcTemplate.update(SQL_UPDATE_ANSWER,
                entity.getQuestionId(),
                entity.getText(),
                entity.isCorrect(),
                entity.getEntityId());
        return result;
    }

    @Override
    public List<Answer> findByQuestionId(long questionId) throws DaoException {
        List<Answer> result = jdbcTemplate.queryForList(SQL_SELECT_ANSWER_BY_QUESTION_ID, new AnswerMapper(), questionId);
        return result;
    }
}
