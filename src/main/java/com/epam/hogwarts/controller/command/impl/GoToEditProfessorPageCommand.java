package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class GoToEditProfessorPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GoToEditProfessorPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        long professorId = Long.parseLong(request.getParameter(RequestParameter.PROFESSOR_ID));
        UserService userService = ServiceProvider.getInstance().getUserService();
        Optional<User> professorOptional;
        try {
            professorOptional = userService.findUserById(professorId);
        } catch (ServiceException e) {
            logger.error("Error {} while searching for professor with id {}", e.getMessage(), professorId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        if (professorOptional.isEmpty()) {
            logger.error("Can't find professor with id {}", professorId);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        User professor = professorOptional.get();
        logger.info("Filling form with professor info... {}", professor);
        request.setAttribute(RequestAttribute.PROFESSOR, professor);
        return new CommandResult(PagePath.EDIT_PROFESSOR_PAGE, CommandResult.RoutingType.FORWARD);
    }
}
