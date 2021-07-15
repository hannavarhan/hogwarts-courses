package com.epam.hogwarts.dao;

import com.epam.hogwarts.entity.Course;
import com.epam.hogwarts.exception.DaoException;

import java.util.List;

public interface CourseDao extends BaseDao<Course> {

    List<Course> findCoursesByActual(boolean isActual) throws DaoException;

    List<Course> findCoursesByProfessor(long professorId) throws DaoException;
}
