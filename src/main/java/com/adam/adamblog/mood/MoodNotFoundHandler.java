package com.adam.adamblog.mood;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author adam
 * 创建于 2018-02-28 15:09.
 * 处理MoodNotFoundException的Handler.
 */
@ControllerAdvice
public class MoodNotFoundHandler {

    @ExceptionHandler(MoodNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Mood could not be found")
    public void handleNotFound() {
    }

}