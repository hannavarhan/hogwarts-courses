package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.model.entity.Answer;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;

public interface AnswerDao extends BaseDao<Answer> {
    List<Answer> findByQuestionId(long questionId) throws DaoException;
}
