package com.epam.hogwarts.model.service;

import com.epam.hogwarts.model.entity.*;
import com.epam.hogwarts.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getActualCourses(int limit) throws ServiceException;

    Optional<Course> saveCourse(Course course, ArrayList<Theory> theories, ArrayList<QuestionWithAnswers> questions) throws ServiceException;

    boolean deleteCourse(long courseId) throws ServiceException;

    List<Course> getUserCoursesByStatus(long userId, CourseStatus userStatus) throws ServiceException;

    List<Course> getNotUserCourses(long userId) throws ServiceException;

    Optional<Course> findCourseById(long courseId) throws ServiceException;
}
