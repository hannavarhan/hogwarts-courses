package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.entity.UserRole;
import com.epam.hogwarts.model.entity.UserStatus;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import com.epam.hogwarts.util.PasswordEncryptor;
import com.epam.hogwarts.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RegisterProfessorCommand implements Command {

    private static final String POST = "POST";
    private static final Logger logger = LogManager.getLogger(RegisterPupilCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        if (!request.getMethod().equals(POST)) {
            return new CommandResult(PagePath.REGISTER_PROFESSOR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = request.getParameter(RequestParameter.REPEAT_PASSWORD);
        String name = request.getParameter(RequestParameter.USER_NAME);
        String surname = request.getParameter(RequestParameter.USER_SURNAME);
        String email = request.getParameter(RequestParameter.EMAIL);
        String about = request.getParameter(RequestParameter.ABOUT);
        if (!UserValidator.validatePasswordCorrespondence(password, repeatPassword)) {
            logger.error("Passwords do not corresponds");
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.PASSWORD_ERROR);
            return new CommandResult(PagePath.REGISTER_PROFESSOR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        logger.info("Beginning registration for professor with login {}", login);
        UserService service = ServiceProvider.getInstance().getUserService();
        boolean isLoginAvailable;
        try {
            isLoginAvailable = service.isLoginAvailable(login);
        } catch (ServiceException e) {
            logger.error("Error {} while calling isLoginAvailable method for professor", e.getMessage());
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        if (!isLoginAvailable) {
            logger.error("Login isn't available");
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.REGISTER_LOGIN_NOT_AVAILABLE);
            return new CommandResult(PagePath.REGISTER_PROFESSOR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        PasswordEncryptor encryptor = PasswordEncryptor.getInstance();
        User user = new User.Builder()
                .setLogin(login)
                .setPassword(encryptor.encrypt(password))
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setAbout(about)
                .setRole(UserRole.PROFESSOR)
                .setStatus(UserStatus.CONFIRMED)
                .build();
        Optional<User> userResult;
        try {
            userResult = service.registerUser(user);
        } catch (ServiceException e) {
            logger.error("Error {} while saving in db professor {}", e.getMessage(), user);
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        User registeredUser = userResult.orElse(null);
        if (registeredUser == null) {
            logger.error("registered professor is null");
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.REGISTER_ERROR);
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
        }
        logger.info("Professor {} is registered", registeredUser);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.USER, registeredUser);
        session.setAttribute(SessionAttribute.USER_ROLE, user.getRole());
        return new CommandResult(PagePath.ADMIN_PERSONAL_PAGE, CommandResult.RoutingType.REDIRECT);
    }
}
