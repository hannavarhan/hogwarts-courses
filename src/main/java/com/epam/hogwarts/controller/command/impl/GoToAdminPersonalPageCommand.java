package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.Command;
import com.epam.hogwarts.controller.command.CommandResult;
import com.epam.hogwarts.controller.command.PagePath;
import com.epam.hogwarts.controller.command.RequestAttribute;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.epam.hogwarts.controller.command.RequestAttribute.PROFESSOR_LIST;

public class GoToAdminPersonalPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToAdminPersonalPageCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult;
        UserService userService = ServiceProvider.getInstance().getUserService();
        try {
            List<User> professorList = userService.getActualProfessors();
            request.setAttribute(PROFESSOR_LIST, professorList);
            commandResult = new CommandResult(PagePath.ADMIN_PERSONAL_PAGE, CommandResult.RoutingType.FORWARD);
        } catch (ServiceException e) {
            logger.error("Error {}", e.getMessage());
            request.setAttribute(RequestAttribute.ERROR, e);
            commandResult = new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.REDIRECT);
        }
        return commandResult;
    }
}
