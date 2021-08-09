package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.model.entity.CourseStatus;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToPupilPersonalPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToPupilPersonalPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CourseService service = ServiceProvider.getInstance().getCourseService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        long userId = user.getEntityId();
        List<Course> courses;
        try {
            String courseListTypeString = request.getParameter(RequestParameter.COURSE_LIST_TYPE);
            RequestParameter.CourseListType courseListType = courseListTypeString == null ?
                    RequestParameter.CourseListType.UNFINISHED :
                    RequestParameter.CourseListType.valueOf(courseListTypeString.toUpperCase());
            switch (courseListType) {
                case FINISHED -> {
                    courses = service.getUserCoursesByStatus(userId, CourseStatus.FINISHED);
                    request.setAttribute(RequestAttribute.COURSE_LIST, courses);
                    logger.info("Pupil (id:{}) finished courses: {}", userId, courses);
                    return new CommandResult(PagePath.PUPIL_PERSONAL_PAGE, CommandResult.RoutingType.FORWARD);
                }
                case ALL -> {
                    courses = service.getNotUserCourses(userId);
                    request.setAttribute(RequestAttribute.COURSE_LIST, courses);
                    logger.info("Pupil (id:{}) not started courses: {}", userId, courses);
                    return new CommandResult(PagePath.PUPIL_PERSONAL_PAGE, CommandResult.RoutingType.FORWARD);
                }
                default -> {
                    courses = service.getUserCoursesByStatus(userId, CourseStatus.IN_PROGRESS);
                    request.setAttribute(RequestAttribute.COURSE_LIST, courses);
                    logger.info("Pupil (id:{}) active courses: {}", userId, courses);
                    return new CommandResult(PagePath.PUPIL_PERSONAL_PAGE, CommandResult.RoutingType.FORWARD);
                }
            }
        } catch (ServiceException e) {
            logger.error("Can't get active courses for user with id {}", userId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
    }
}
