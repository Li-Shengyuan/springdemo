package com.lsy.ibook.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID() {
        // e7ae22c2-a2e4-4fd3-ad0e-957af0f7e604
        String uuidStr = UUID.randomUUID().toString();
        // 去掉 uuid 中的 "-"
        String uuid = uuidStr.replaceAll("-","");
        return uuid;
    }
}
