package com.customize.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {
    private static final String key = "customize2020";

    public static String encryptedPassword(String password) {
        return DigestUtils.md5Hex(key.concat(DigestUtils.md5Hex(password)));
    }
}
