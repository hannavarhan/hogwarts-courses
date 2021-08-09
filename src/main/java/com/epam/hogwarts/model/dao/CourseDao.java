package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.model.entity.CourseStatus;

import java.util.List;

public interface CourseDao extends BaseDao<Course> {

    List<Course> findCoursesByActual(boolean isActual) throws DaoException;

    List<Course> findCoursesByActual(boolean isActual, int limit) throws DaoException;

    List<Course> findCoursesByProfessor(long professorId) throws DaoException;

    List<Course> findCoursesByUserAndStatus(long userId, CourseStatus userStatus) throws DaoException;

    boolean updateCourseActual(long courseId, boolean isActual) throws DaoException;
}
