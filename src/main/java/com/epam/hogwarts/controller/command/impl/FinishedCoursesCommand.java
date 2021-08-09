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

public class FinishedCoursesCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GoToPupilPersonalPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CourseService service = ServiceProvider.getInstance().getCourseService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        long userId = user.getEntityId();
        List<Course> finishedCourses;
        try {
            finishedCourses = service.getUserCoursesByStatus(userId, CourseStatus.FINISHED);
            request.setAttribute(RequestAttribute.ACTIVE_COURSE_LIST, false);
            request.setAttribute(RequestAttribute.ALL_COURSE_LIST, false);
            request.setAttribute(RequestAttribute.FINISHED_COURSE_LIST, true);
            request.setAttribute(RequestAttribute.COURSE_LIST, finishedCourses);
            logger.info("Pupil (id:{}) finished courses: {}", userId, finishedCourses);
            return new CommandResult(PagePath.PUPIL_PERSONAL_PAGE, CommandResult.RoutingType.FORWARD);
        } catch (ServiceException e) {
            logger.error("Can't get finished courses for user with id {}", userId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
    }
}
