package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.Theory;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;

public interface TheoryDao extends BaseDao<Theory> {
    List<Theory> findByCoursesId(Long courseId) throws DaoException;

}
