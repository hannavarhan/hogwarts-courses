package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.entity.UserStatus;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import com.epam.hogwarts.util.PasswordEncryptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyTokenCommand implements Command {

    private static final String POST = "POST";
    private static final Logger logger = LogManager.getLogger(VerifyTokenCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        if (!request.getMethod().equals(POST)) {
            return new CommandResult(PagePath.TOKEN_PAGE, CommandResult.RoutingType.FORWARD);
        }
        String token = request.getParameter(RequestParameter.TOKEN);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
        long pupilId = user.getEntityId();
        PasswordEncryptor encryptor = PasswordEncryptor.getInstance();
        String expected = encryptor.encrypt(String.valueOf(pupilId));
        if (!expected.equals(token)) {
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.TOKEN_ERROR);
            return new CommandResult(PagePath.TOKEN_PAGE, CommandResult.RoutingType.FORWARD);
        }
        user.setStatus(UserStatus.CONFIRMED);
        UserService service = ServiceProvider.getInstance().getUserService();
        try {
            service.updateUser(user);
        } catch (ServiceException e) {
            logger.error("Error {} while calling updateUser method", e.getMessage());
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        request.setAttribute(RequestAttribute.USER, user);
        return new CommandResult(PagePath.PUPIL_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
    }
}
