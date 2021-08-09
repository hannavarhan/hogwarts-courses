package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.entity.Feedback;

import java.util.List;

public interface FeedbackDao extends BaseDao<Feedback> {

    List<Feedback> findByCourse(long courseId) throws DaoException;

    int countByCourse(long courseId) throws DaoException;
}
