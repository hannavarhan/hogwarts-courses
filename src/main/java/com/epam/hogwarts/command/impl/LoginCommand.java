package com.epam.hogwarts.command.impl;

import com.epam.hogwarts.command.*;
import com.epam.hogwarts.entity.User;
import com.epam.hogwarts.entity.UserStatus;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.service.ServiceProvider;
import com.epam.hogwarts.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String POST = "POST";
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        if (!request.getMethod().equals(POST)) {
            return new CommandResult(PagePath.LOGIN_PAGE, CommandResult.RoutingType.FORWARD);
        }
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        UserService service = ServiceProvider.getInstance().getUserService();
        Optional<User> userResult;
        try {
            userResult = service.authenticate(login, password);
        } catch (ServiceException e) {
            logger.error("Error {} in LoginCommand", e.getMessage());
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        User user = userResult.orElse(null);
        if (user == null || user.getStatus() == UserStatus.NOT_ACTUAL) {
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.LOGIN_ERROR);
            return new CommandResult(PagePath.LOGIN_PAGE, CommandResult.RoutingType.FORWARD);
        }
        if (user.getStatus() == UserStatus.NOT_CONFIRMED) {
            request.setAttribute(RequestAttribute.EMAIL_NOT_CONFIRMED, true);
            return new CommandResult(PagePath.LOGIN_PAGE, CommandResult.RoutingType.FORWARD);
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.USER, user);
        session.setAttribute(SessionAttribute.USER_ROLE, user.getRole());
        return new CommandResult(PagePath.PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
    }
}
