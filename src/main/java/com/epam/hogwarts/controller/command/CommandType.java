package com.epam.hogwarts.controller.command;

public enum CommandType {
    LOGIN,
    LOGOUT,
    REGISTER_PUPIL,
    REGISTER_PROFESSOR,
    VERIFY_TOKEN,
    START_PAGE,
    GO_TO_LOGIN_PAGE,
    GO_TO_REGISTER_PAGE,

    PERSONAL_PAGE,
    DEFAULT,
    CHANGE_LANGUAGE,
    CONFIRM_EMAIL,
    GO_TO_SEND_EMAIL_AGAIN_PAGE,
    SEND_EMAIL_AGAIN,
    GO_TO_EMAIL_CONFIRMED_PAGE,
    GO_TO_EMAIL_SENT_PAGE
}
