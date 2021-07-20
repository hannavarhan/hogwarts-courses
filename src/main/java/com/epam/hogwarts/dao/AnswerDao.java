package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.Answer;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;

public interface AnswerDao extends BaseDao<Answer> {
    List<Answer> findByQuestionId(long questionId) throws DaoException;
}
