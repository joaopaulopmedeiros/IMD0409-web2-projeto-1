package com.github.techmove.factories;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SaltFactory {

    private static final int SALT_LENGTH = 16;

    public static String create() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return bytesToHex(salt);
    }

    private static String bytesToHex(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(1, bytes);
        String hex = bigInteger.toString(16);
        int paddingLength = (bytes.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }
}