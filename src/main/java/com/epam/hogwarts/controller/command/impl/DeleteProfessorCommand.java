package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.service.CourseService;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteProfessorCommand implements Command {

    private static final Logger logger = LogManager.getLogger(DeleteProfessorCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        long professorId = Long.parseLong(request.getParameter(RequestParameter.PROFESSOR_ID));
        UserService userService = ServiceProvider.getInstance().getUserService();
        try {
            userService.deleteUser(professorId);
            return new CommandResult(PagePath.GO_TO_ADMIN_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
        } catch (ServiceException e) {
            logger.error("Can't delete professor command, cause {}", e.getMessage());
            request.setAttribute(RequestAttribute.ERROR, true);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
    }
}
