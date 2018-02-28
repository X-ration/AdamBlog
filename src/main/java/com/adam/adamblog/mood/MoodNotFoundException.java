package com.adam.adamblog.mood;

/**
 * @author adam
 * 创建于 2018-02-28 15:06.
 * 心情对象未找到的异常。
 */
public class MoodNotFoundException extends Exception{

    public MoodNotFoundException(String message) {
        super(message);
    }

    public MoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
