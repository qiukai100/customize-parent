package com.customize.common.utils.system;

import java.util.UUID;

public class UUIDUtil {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
