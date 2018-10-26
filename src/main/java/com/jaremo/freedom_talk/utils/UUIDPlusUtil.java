package com.jaremo.freedom_talk.utils;

import java.util.UUID;

/**
 * @描述: 获取uuid
 * @Author: pyj
 * @DateTime: 2018/10/26 0026--下午 4:28
 */
public class UUIDPlusUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","");
        return uuid;
    }
}
