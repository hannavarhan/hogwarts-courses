package com.epam.hogwarts.controller.command;

public class ErrorKey {
    public static final String INVALID_ACTIVATION_LINK = "error.invalid_activation_link";
    public static final String INVALID_REQUEST = "error.invalid_request";
    public static final String LOGIN_ERROR = "login_page.error_message";
    public static final String PASSWORD_ERROR = "register_page.error_message";
    public static final String REGISTER_ERROR = "register_page.error_message";
    public static final String REGISTER_LOGIN_NOT_AVAILABLE = "register_page.error.login_not_available";
    public static final String REGISTER_EMAIL_NOT_SENT = "register_page.error.email_not_sent";
    public static final String TOKEN_ERROR = "token_page.error_message";
    public static final String EMAIL_NOT_CONFIRMED = "error.email_not_confirmed";
    public static final String LOGIN_USER_NOT_APPROVED = "login_page.not_approved";
    public static final String LOGIN_USER_NOT_ACTIVE = "login_page.blocked";
    public static final String SIGNUP_INVALID_REQUEST = "signup.error.illegal_request";
    public static final String SIGNUP_EMAIL_NOT_AVAILABLE = "signup.error.email_not_available";
    public static final String NOT_ENOUGH_RIGHTS = "error.not_enough_rights";
    public static final String ALREADY_LOGGED_IN = "error.already_logged_in";

    private ErrorKey() {
    }
}
