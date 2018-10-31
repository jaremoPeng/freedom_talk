package com.jaremo.freedom_talk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @描述: 时间类
 * @Author: pyj
 * @DateTime: 2018/10/31 0031--下午 2:25
 */
public class TimeUtil {

    private static final SimpleDateFormat FORMAT_ONE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 日期加时间
    private static final SimpleDateFormat FORMAT_TWO = new SimpleDateFormat("yyyy-MM-dd"); // 日期

    /**
     * 功能描述 给定年份自动确认年龄
     *
     * @param birthDate 出生日期
     * @return java.lang.Integer
     * @author pyj
     * @date 2018/10/31 0031
     */
    public static Integer confirmAge(String birthDate) {
        String nowStr = dateToString(new Date(), 2);
        String[] oldStrs = birthDate.split("-");
        String[] nowStrs = nowStr.split("-");

        Integer old = Integer.parseInt(oldStrs[0]);
        Integer now = Integer.parseInt(nowStrs[0]);

        Integer result = now - old;
        if (result < 0) {
            return null;
        }
        return result;
    }

    /**
     * 功能描述 日期类型转string类型
     *
     * @param date     目标
     * @param formatId 选择格式 默认是yyyy-MM-dd形式
     * @return java.lang.String
     * @author pyj
     * @date 2018/10/31 0031
     */
    public static String dateToString(Date date, int formatId) {
        if (formatId == 1) {
            return FORMAT_ONE.format(date);
        }
        return FORMAT_TWO.format(date);
    }

    /**
     * 功能描述 string类型转date类型
     *
     * @param targetStr 目标
     * @param formatId  选择格式
     * @return java.util.Date
     * @author pyj
     * @date 2018/10/31 0031
     */
    public static Date stringToDate(String targetStr, int formatId) {
        try {
            if (formatId == 1) {
                return FORMAT_ONE.parse(targetStr);
            }
            return FORMAT_TWO.parse(targetStr);
        } catch (ParseException e) {
            throw new RuntimeException("转换date类型失败" + e.getMessage());
        }
    }
}
