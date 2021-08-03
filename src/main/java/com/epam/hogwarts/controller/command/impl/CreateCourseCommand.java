package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.*;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

public class CreateCourseCommand implements Command {

    private static final String POST = "POST";
    private static final Logger logger = LogManager.getLogger(CreateCourseCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        if (!request.getMethod().equals(POST)) {
            return new CommandResult(PagePath.CREATE_COURSE_PAGE, CommandResult.RoutingType.FORWARD);
        }
        Course course = getCourseFromParameters(request);
        ArrayList<Theory> theories = getTheoriesFromRequest(request);
        ArrayList<QuestionWithAnswers> questionsWithAnswers = getQuestionWithAnswersFromRequest(request);
        ArrayList<Answer> answers = (ArrayList<Answer>) request.getAttribute(RequestAttribute.ANSWERS);

        CourseService courseService = ServiceProvider.getInstance().getCourseService();
        try {
            courseService.saveCourse(course, theories, questionsWithAnswers);
        } catch (ServiceException e) {
            logger.error("Can't save course {}", course);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        return new CommandResult(PagePath.PROFESSOR_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
    }

    private Course getCourseFromParameters(HttpServletRequest request) {
        String name = request.getParameter(RequestParameter.COURSE_NAME);
        int complexity = Integer.parseInt(request.getParameter(RequestParameter.COURSE_COMPLEXITY));
        String description = request.getParameter(RequestParameter.COURSE_DESCRIPTION);
        String conclusion = request.getParameter(RequestParameter.COURSE_CONCLUSION);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        long professorId = user.getEntityId();
        Course course = new Course.Builder()
                .setName(name)
                .setComplexity(complexity)
                .setConclusion(conclusion)
                .setDescription(description)
                .setCreationDate(new Date())
                .setProfessorId(professorId)
                .build();
        return course;
    }

    private ArrayList<QuestionWithAnswers> getQuestionWithAnswersFromRequest(HttpServletRequest request) {
        ArrayList<QuestionWithAnswers> result = new ArrayList<>();
        String[] text = request.getParameterValues(RequestParameter.QUESTION_TEXT);
        String[] answerAmountStr = request.getParameterValues(RequestParameter.QUESTION_ANSWER_AMOUNT);
        String[] answerText = request.getParameterValues(RequestParameter.ANSWER_TEXT);
        String[] answerIsCorrect = request.getParameterValues(RequestParameter.ANSWER_IS_CORRECT); //todoooooooooooo
        for (int i = 0; i < text.length; i++) {
            Question question = new Question(1);
            question.setText(text[i]);
            int answerAmount = Integer.parseInt(answerAmountStr[i]);
            ArrayList<Answer> answers = new ArrayList<>();
            for (int j = 0; j < answerAmount; j++) {
                Answer answer = new Answer(1);
                answer.setText(answerText[i*answerAmount + j]);
            }
        }

    }

    private ArrayList<Theory> getTheoriesFromRequest(HttpServletRequest request) {
        ArrayList<Theory> result = new ArrayList<>();
        String[] text = request.getParameterValues(RequestParameter.THEORY_TEXT);
        for (String s : text) {
            Theory theory = new Theory(1);
            theory.setText(s);
            result.add(theory);
        }
        return result;
    }
}
