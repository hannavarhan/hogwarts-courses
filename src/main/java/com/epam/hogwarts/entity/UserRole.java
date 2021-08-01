package com.epam.hogwarts.entity;

import com.epam.hogwarts.exception.EnumParseException;

public enum UserRole {
    ADMIN("admin"),
    PROFESSOR("professor"),
    PUPIL("pupil"),
    GUEST("guest");

    private String title;

    UserRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
/*
    public UserRole getUserRole(String role) throws EnumParseException {
        switch (role) {
            case "admin":
                return UserRole.ADMIN;
            case "professor":
                return UserRole.PROFESSOR;
            case "pupil":
                return UserRole.PUPIL;
            default:
                throw new EnumParseException("Can't parse \"" + role + "\" to UserRole");
        }
    }*/
}
