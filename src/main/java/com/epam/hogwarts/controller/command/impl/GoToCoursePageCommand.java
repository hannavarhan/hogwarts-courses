package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.model.entity.Feedback;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.FeedbackService;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class GoToCoursePageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToPupilPersonalPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        long courseId = Long.parseLong(request.getParameter(RequestParameter.COURSE_ID));
        CourseService courseService = ServiceProvider.getInstance().getCourseService();
        Optional<Course> courseOptional;
        try {
            courseOptional = courseService.findCourseById(courseId);
        } catch (ServiceException e) {
            logger.error("Error while getting course by id {}", courseId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        if (!courseOptional.isPresent()) {
            logger.error("Can't get course by id {}", courseId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        Course course = courseOptional.get();
        logger.info("Course {} was found by id {}", course, courseId);
        request.setAttribute(RequestAttribute.COURSE, course);

        long professorId = course.getProfessorId();
        UserService userService = ServiceProvider.getInstance().getUserService();
        Optional<User> professorOptional;
        try {
            professorOptional = userService.findUserById(professorId);
        } catch (ServiceException e) {
            logger.error("Error while getting course author by id {}", professorId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        if (professorOptional.isEmpty()) {
            logger.error("Can't get course by author id {}", professorId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        User professor = professorOptional.get();
        logger.info("Course author {} was found by id {}", professor, professorId);
        request.setAttribute(RequestAttribute.PROFESSOR, professor);

        FeedbackService feedbackService = ServiceProvider.getInstance().getFeedbackService();
        List<Feedback> feedbackList;
        try {
            feedbackList = feedbackService.findFeedbackByCourse(courseId);
        } catch (ServiceException e) {
            logger.error("Error while getting feedbackList by course id {}", courseId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        logger.info("feedbackList with size {} was found by id {}", feedbackList.size(), courseId);
        request.setAttribute(RequestAttribute.FEEDBACK_LIST_SIZE, feedbackList.size());
        request.setAttribute(RequestAttribute.FEEDBACK_LIST, feedbackList);
        return new CommandResult(PagePath.COURSE_PAGE, CommandResult.RoutingType.FORWARD);
    }
}
