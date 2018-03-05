package com.adam.adamblog.util;

/**
 * @author adam
 * 创建于 2018-03-05 12:24.
 * 字符串处理相关。
 */
public class StringUtil {

    public static String getOrCreate(String s, String defaultValue) {
        if(s == null || s.equals("")) {
            return defaultValue;
        } else {
            return s;
        }
    }

    public static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }

}
