package com.adam.adamblog.util;

import java.time.LocalDateTime;

/**
 * @author adam
 * 创建于 2018-03-02 21:01.
 * 用于对LocalDateTime对象格式化。
 */
public class LocalDateTimeFormatter {

    /**
     * 将LocalDateTime格式化为yyyy-MM-dd HH:mm格式。
     * @param localDateTime
     * @return 格式化字符串
     */
    public static String format(LocalDateTime localDateTime) {
        return localDateTime.getYear() + "-"
                + localDateTime.getMonthValue() + "-"
                + localDateTime.getDayOfMonth() + " "
                + localDateTime.getHour() + ":"
                + localDateTime.getMinute();
    }

}
