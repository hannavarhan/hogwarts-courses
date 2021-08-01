package com.epam.hogwarts.util;

public class PasswordEncryptor {
    private static final PasswordEncryptor instance = new PasswordEncryptor();

    private PasswordEncryptor() {}

    public static PasswordEncryptor getInstance() {
        return instance;
    }

    public String encrypt(String password) {
        //todo:
        return "lalala";
    }
}
