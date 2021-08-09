package com.epam.hogwarts.controller.command;

public class PagePath {
    public static final String LOGIN_PAGE = "common/login.jsp";
    public static final String REGISTER_PAGE = "common/register.jsp";
    public static final String TOKEN_PAGE = "common/token.jsp";
    public static final String START_PAGE = "common/start.jsp";
    public static final String ERROR_PAGE = "error/error.jsp";

    public static final String ADMIN_PERSONAL_PAGE = "admin/admin_personal.jsp";
    public static final String GO_TO_ADMIN_PERSONAL_PAGE = "/controller?command=go_to_admin_page";
    public static final String PUPIL_PERSONAL_PAGE = "personal/pupil_personal.jsp";
    public static final String GO_TO_PUPIL_PERSONAL_PAGE = "/controller?command=go_to_pupil_page";
    public static final String PROFESSOR_PERSONAL_PAGE = "personal/professor_personal.jsp";
    public static final String CREATE_COURSE_PAGE = "personal/create_course.jsp";
    public static final String GO_TO_STUDY_COURSE_PAGE = "personal/theory.jsp";

    public static final String EDIT_PROFESSOR_PAGE = "admin/edit_professor.jsp";
    public static final String REGISTER_PROFESSOR_PAGE = "admin/register_professor.jsp";




    private PagePath() {
    }
}
