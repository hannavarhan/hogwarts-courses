package com.epam.hogwarts.validator;

import com.epam.hogwarts.model.entity.User;

public class UserValidator {

    public static boolean validate(User user) {
        //todo: add validation
        return true;
    }

    public static boolean validateLogin(String login) {
        //todo: add validation
        return true;
    }

    public static boolean validatePassword(String password) {
        //todo: add validation
        return true;
    }

    public static boolean validatePasswordCorrespondence(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }
}
