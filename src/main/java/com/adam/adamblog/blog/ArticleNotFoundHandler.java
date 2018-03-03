package com.adam.adamblog.blog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author adam
 * 创建于 2018-03-02 21:30.
 * 处理ArticleNotFoundException的handler。
 */
@ControllerAdvice
public class ArticleNotFoundHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Article could not be found")
    public void handleNotFound() {
    }

}
