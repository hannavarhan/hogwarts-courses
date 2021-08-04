package com.epam.hogwarts.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
    private static final PasswordEncryptor instance = new PasswordEncryptor();
    private String key; // 128 bit key
    private Key aesKey;
    private String  algorithm;
    // Create key and cipher
    private Cipher cipher;

    private PasswordEncryptor() {
        key = SystemProperties.getSecurityKey();
        algorithm = SystemProperties.getSecurityAlgorithm();
        aesKey = new SecretKeySpec(key.getBytes(), algorithm);
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            //e.printStackTrace();
        }
    }

    public static PasswordEncryptor getInstance() {
        return instance;
    }

    public String encrypt(String password) {
        String result = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            result = new String(encrypted, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String decrypt(String encrypted) {
        String decrypted = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(encrypted.getBytes()));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return decrypted;
    }
}
