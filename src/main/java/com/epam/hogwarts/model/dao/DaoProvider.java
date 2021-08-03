package com.epam.hogwarts.model.dao;

import com.epam.hogwarts.model.dao.impl.*;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
    private static final UserDao userDao = UserDaoImpl.getInstance();
    private static final CourseDao courseDao = CourseDaoImpl.getInstance();
    private static final TheoryDao theoryDao = TheoryDaoImpl.getInstance();
    private static final QuestionDao questionDao = QuestionDaoImpl.getInstance();
    private static final AnswerDao answerDao = AnswerDaoImpl.getInstance();

    private DaoProvider() {}

    public static DaoProvider getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public TheoryDao getTheoryDao() {
        return theoryDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }


}
