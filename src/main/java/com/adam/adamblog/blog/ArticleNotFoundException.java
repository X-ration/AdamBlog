package com.adam.adamblog.blog;

/**
 * @author adam
 * 创建于 2018-03-02 21:29.
 * 文章异常。
 */
public class ArticleNotFoundException extends Exception {

    public ArticleNotFoundException(String message) {
        super(message);
    }

    public ArticleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
