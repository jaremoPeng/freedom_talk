package com.jaremo.freedom_talk.utils;

import java.util.Random;

/**
 * @描述: 生成指定位数的随机数
 * @Author: pyj
 * @DateTime: 2018/10/26 0026--下午 4:07
 */
public class RandomUtil {
    /**
     * 生成指定位数的随机数
     * @param length
     * @return
     */
    public static String getRandom(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }
}
