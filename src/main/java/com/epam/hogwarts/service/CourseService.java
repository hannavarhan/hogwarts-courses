package com.epam.hogwarts.service;

import com.epam.hogwarts.entity.Answer;
import com.epam.hogwarts.entity.Course;
import com.epam.hogwarts.entity.Question;
import com.epam.hogwarts.entity.Theory;
import com.epam.hogwarts.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getActualCourses(int limit) throws ServiceException;

    Optional<Course> saveCourse(Course course, ArrayList<Theory> theories, ArrayList<Question> questions, ArrayList<Answer> answers) throws ServiceException;
}
