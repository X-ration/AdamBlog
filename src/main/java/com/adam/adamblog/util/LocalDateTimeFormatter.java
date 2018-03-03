package com.adam.adamblog.util;

import java.time.LocalDateTime;

/**
 * @author adam
 * 创建于 2018-03-02 21:01.
 * 用于对LocalDateTime对象格式化。
 */
public class LocalDateTimeFormatter {

    public static String formatFull(LocalDateTime localDateTime) {
        return GetValueUtil.getYear(localDateTime) + "-"
                + GetValueUtil.getMonth(localDateTime) + "-"
                + GetValueUtil.getDay(localDateTime) + " "
                + GetValueUtil.getHour(localDateTime) + ":"
                + GetValueUtil.getMinute(localDateTime);
    }

    public static String formatDateFull(LocalDateTime localDateTime) {
        return localDateTime.getYear() + "-"
                + GetValueUtil.getMonth(localDateTime) + "-"
                + GetValueUtil.getDay(localDateTime);
    }

    public static String formatTimeHourMinute(LocalDateTime localDateTime) {
        return GetValueUtil.getHour(localDateTime) + ":"
                + GetValueUtil.getMinute(localDateTime);
    }

    public static String formatDateMonthDay(LocalDateTime localDateTime) {
        return GetValueUtil.getMonth(localDateTime) + "-"
                + GetValueUtil.getDay(localDateTime);
    }

    static class GetValueUtil {
        private static String getYear(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(0,4);
        }
        private static String getMonth(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(5,7);
        }
        private static String getDay(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(8,10);
        }
        private static String getHour(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(11,13);
        }
        private static String getMinute(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(14,16);
        }
        private static String getSecond(LocalDateTime localDateTime) {
            return localDateTime.toString().substring(17,19);
        }
    }

}
