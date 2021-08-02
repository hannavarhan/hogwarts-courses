package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.Question;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;

public interface QuestionDao extends BaseDao<Question> {

    List<Question> findByCourseId(Long courseId) throws DaoException;
}
