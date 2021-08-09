package com.epam.hogwarts.controller.command.impl;

import com.epam.hogwarts.controller.command.*;
import com.epam.hogwarts.exception.NotificationException;
import com.epam.hogwarts.exception.ServiceException;
import com.epam.hogwarts.model.entity.EmailNotification;
import com.epam.hogwarts.model.entity.User;
import com.epam.hogwarts.model.entity.UserRole;
import com.epam.hogwarts.model.entity.UserStatus;
import com.epam.hogwarts.model.service.EmailNotificationSenderService;
import com.epam.hogwarts.model.service.ServiceProvider;
import com.epam.hogwarts.model.service.UserService;
import com.epam.hogwarts.util.PasswordEncryptor;
import com.epam.hogwarts.util.SystemProperties;
import com.epam.hogwarts.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RegisterPupilCommand implements Command {

    private static final String POST = "POST";
    private static final Logger logger = LogManager.getLogger(RegisterPupilCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request) {
        if (!request.getMethod().equals(POST)) {
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
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
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
        }
        logger.info("Beginning registration for user with login {}", login);
        UserService service = ServiceProvider.getInstance().getUserService();
        boolean isLoginAvailable;
        try {
            isLoginAvailable = service.isLoginAvailable(login);
        } catch (ServiceException e) {
            logger.error("Error {} while calling isLoginAvailable method", e.getMessage());
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        if (!isLoginAvailable) {
            logger.error("Login isn't available");
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.REGISTER_LOGIN_NOT_AVAILABLE);
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
        }
        PasswordEncryptor encryptor = PasswordEncryptor.getInstance();
        User user = new User.Builder()
                .setLogin(login)
                .setPassword(encryptor.encrypt(password))
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setAbout(about)
                .setRole(UserRole.PUPIL)
                .setStatus(UserStatus.NOT_CONFIRMED)
                .build();
        Optional<User> userResult;
        try {
            userResult = service.registerUser(user);
        } catch (ServiceException e) {
            logger.error("Error {} while saving in db", e.getMessage());
            return new CommandResult(PagePath.ERROR_PAGE, CommandResult.RoutingType.FORWARD);
        }
        User registeredUser = userResult.orElse(null);
        if (registeredUser == null) {
            logger.error("registeredUser is null");
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.REGISTER_ERROR);
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
        }
        logger.info("User {} is registered", registeredUser);
        EmailNotificationSenderService emailService = ServiceProvider.getInstance().getEmailService();
        String token = encryptor.encrypt(String.valueOf(registeredUser.getEntityId()));
        String emailText = "Your verification token is " + token;
        EmailNotification emailNotification = new EmailNotification.Builder()
                .setEmail(registeredUser.getEmail())
                .setSubject("Email verification") //fixme: add localization
                .setText(emailText)
                .setAllowableAttempts(SystemProperties.getNotificationAttempts())
                .build();
        try {
            logger.info("Trying to send email to {}", registeredUser.getEmail());
            emailService.sendMessage(emailNotification);
        } catch (NotificationException e) {
            logger.error("Can't send email notification, cause {}", e.getMessage());
            request.setAttribute(RequestAttribute.ERROR, true);
            request.setAttribute(RequestAttribute.ERROR_KEY, ErrorKey.REGISTER_EMAIL_NOT_SENT);
            return new CommandResult(PagePath.REGISTER_PAGE, CommandResult.RoutingType.FORWARD);
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.USER, registeredUser);
        session.setAttribute(SessionAttribute.USER_ROLE, user.getRole());
        return new CommandResult(PagePath.TOKEN_PAGE, CommandResult.RoutingType.REDIRECT);
    }
}
