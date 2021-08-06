package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.ServiceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteCourseCommand implements Command {

    private static final Logger logger = LogManager.getLogger(DeleteCourseCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        long courseId = Long.parseLong(request.getParameter(RequestParameter.COURSE_ID));
        CourseService courseService = ServiceProvider.getInstance().getCourseService();
        try {
            courseService.deleteCourse(courseId);
            return new CommandResult(PagePath.PROFESSOR_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
        } catch (ServiceException e) {
            logger.error("Can't delete course command, cause {}", e.getMessage());
            request.setAttribute(RequestAttribute.ERROR, true);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }

    }
}
