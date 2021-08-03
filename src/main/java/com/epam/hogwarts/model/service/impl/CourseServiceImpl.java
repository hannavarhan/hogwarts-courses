package com.epam.hogwarts.model.service.impl;

import com.epam.hogwarts.model.dao.*;
import com.epam.hogwarts.model.entity.*;
import com.epam.hogwarts.exception.DaoException;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.service.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private static final DaoProvider daoProvider = DaoProvider.getInstance();
    private static final CourseDao courseDao = daoProvider.getCourseDao();
    private static final TheoryDao theoryDao = daoProvider.getTheoryDao();
    private static final QuestionDao questionDao = daoProvider.getQuestionDao();
    private static final AnswerDao answerDao = daoProvider.getAnswerDao();
    private static final Logger logger = LogManager.getLogger(CourseServiceImpl.class);

    @Override
    public List<Course> getActualCourses(int limit) throws ServiceException {
        try {
            List<Course> result = courseDao.findCoursesByActual(true, limit);
            return result;
        } catch (DaoException e) {
            logger.error("Error {} in getActualCourses", e.getMessage());
            throw new ServiceException("Can't get actual courses");
        }
    }

    @Override
    public Optional<Course> saveCourse(Course course, ArrayList<Theory> theories, ArrayList<QuestionWithAnswers> questionWithAnswers) throws ServiceException {
        try {
            Optional<Course> courseOptional = courseDao.insert(course);
            if (courseOptional.isEmpty()) {
                logger.error("Couldn't insert course {}", course);
                throw new ServiceException("Couldn't insert course");
            }
            Course insertedCourse = courseOptional.get();
            long courseId = insertedCourse.getEntityId();
            for (Theory theory : theories) {
                theory.setCourseId(courseId);
                theoryDao.insert(theory);
            }
            for (QuestionWithAnswers questionWithAnswer : questionWithAnswers) {
                Question question = questionWithAnswer.getQuestion();
                question.setEntityId(courseId);
                Optional<Question> questionOptional = questionDao.insert(question);
                if (questionOptional.isEmpty()) {
                    logger.error("Couldn't insert question {}", question);
                    throw new ServiceException("Couldn't insert question");
                }
                long questionId = questionOptional.get().getEntityId();
                List<Answer> currentAnswers = questionWithAnswer.getAnswers();
                for (Answer answer : currentAnswers) {
                    answer.setQuestionId(questionId);
                    answerDao.insert(answer);
                }
            }
            return courseOptional;
        } catch (DaoException e) {
            logger.error("Error {} in saveCourse", e.getMessage());
            throw new ServiceException("Can't save course");
        }
    }
}
