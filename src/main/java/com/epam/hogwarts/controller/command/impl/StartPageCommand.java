package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.model.entity.Course;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.util.SystemProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.epam.hogwarts.controller.command.RequestAttribute.COURSE_LIST;

public class StartPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(StartPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult;
        CourseService courseService = ServiceProvider.getInstance().getCourseService();
        int limit = SystemProperties.getPageLimit();
        try {
            List<Course> courseList = courseService.getActualCourses(limit);
            request.setAttribute(COURSE_LIST, courseList);
            commandResult = new CommandResult(PagePath.START_PAGE, CommandResult.RoutingType.FORWARD);
        } catch (ServiceException e) {
            logger.error("Error {}", e.getMessage());
            request.setAttribute(RequestAttribute.ERROR, e);
            commandResult = new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        return commandResult;
    }
}
