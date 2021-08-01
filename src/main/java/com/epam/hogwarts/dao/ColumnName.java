package com.epam.hogwarts.dao;

public class ColumnName {
    /* users table */
    public static final String USER_ID = "id_user";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE_ID = "id_role";
    public static final String USER_STATUS = "status";
    public static final String USER_RATING = "rating";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_AVATAR = "avatar";
    public static final String USER_ABOUT = "about";

    /* courses table */
    public static final String COURSE_ID = "id_course";
    public static final String COURSE_PROFESSOR_ID = "id_professor";
    public static final String COURSE_NAME = "name";
    public static final String COURSE_RATING = "rating";
    public static final String COURSE_COMPLEXITY = "complexity";
    public static final String COURSE_CREATION_DATE = "creation_date";
    public static final String COURSE_IS_ACTUAL = "is_actual";
    public static final String COURSE_DESCRIPTION = "description";
    public static final String COURSE_CONCLUSION = "conclusion";
    public static final String COURSE_ICON = "icon";

    /* answers table */
    public static final String ANSWER_ID = "id_answer";
    public static final String ANSWER_QUESTION_ID = "id_question";
    public static final String ANSWER_TEXT = "answer";
    public static final String ANSWER_IS_CORRECT = "is_correct";

    /* feedback table */
    public static final String FEEDBACK_ID = "id";
    public static final String FEEDBACK_COMMENT = "comment";
    public static final String FEEDBACK_ESTIMATOR = "estimator";
    public static final String FEEDBACK_COURSE_ID = "id_course";
    public static final String FEEDBACK_PUPIL_ID = "id_pupil";

    /* questions table */
    public static final String QUESTION_ID = "id_question";
    public static final String QUESTION_TEXT = "text";
    public static final String QUESTION_NUMBER = "number";
    public static final String QUESTION_COURSE_ID = "id_course";

    /* rating table */
    public static final String RATING_ID = "id_rate";
    public static final String RATING_NAME = "rating_name";
    public static final String RATING_LOWER_BOUND = "lower_bound";
    public static final String RATING_UPPER_BOUND = "upper_bound";

    /* roles table */
    public static final String ROLE_ID = "id_role";
    public static final String ROLE_NAME = "role_name";

    /* theory table */
    public static final String THEORY_ID = "id_theory";
    public static final String THEORY_TEXT = "text";
    public static final String THEORY_NUMBER = "number";
    public static final String THEORY_COURSE_ID = "id_course";

    private ColumnName() {}

}
