package com.adam.adamblog.blog;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author adam
 * 创建于 2018-03-05 11:09.
 * 文章表单对象类。
 */
public class ArticleForm {

    private String author;
    private String title;
    private String articleAbstract;
    private List<String> contentParagraphs;
    private Boolean hasImage;
    private Boolean hasLink;
    private String linkUrl;
    private String linkDescription;

    @Override
    public String toString() {
        return "[ArticleForm]Author:"+author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public List<String> getContentParagraphs() {
        return contentParagraphs;
    }

    public void setContentParagraphs(List<String> contentParagraphs) {
        this.contentParagraphs = contentParagraphs;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public Boolean getHasLink() {
        return hasLink;
    }

    public void setHasLink(Boolean hasLink) {
        this.hasLink = hasLink;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }
}
