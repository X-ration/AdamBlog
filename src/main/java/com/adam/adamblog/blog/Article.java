package com.adam.adamblog.blog;

import com.adam.adamblog.util.LocalDateTimeFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adam
 * 创建于 2018-03-02 21:16.
 * 文章对象实体类。
 */
public class Article {

    private String articleId;
    private String author;
    private String title;
    private String articleAbstract;
    private List<String> contentParagraphs;
    private Boolean hasImage;
    private String imageUrl;
    private Boolean hasLink;
    private String linkUrl;
    private String linkDescription;
    private LocalDateTime createdAt;

    public Article(String author, String title, String articleAbstract, List<String> contentParagraphs, Boolean hasImage, String imageUrl, Boolean hasLink, String linkUrl, String linkDescription, LocalDateTime createdAt) {
        this.author = author;
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.contentParagraphs = contentParagraphs;
        this.hasImage = hasImage;
        this.imageUrl = imageUrl;
        this.hasLink = hasLink;
        this.linkUrl = linkUrl;
        this.linkDescription = linkDescription;
        this.createdAt = createdAt;
    }

    public Article() {
        this.author = "";
        this.title = "";
        this.articleAbstract = "";
        this.contentParagraphs = new ArrayList<>();
        this.hasImage = false;
        this.imageUrl = "";
        this.hasLink = false;
        this.linkUrl = "";
        this.linkDescription = "";
        this.createdAt = LocalDateTime.parse("1997-01-01T00:00:00");
    }

    @Override
    public String toString() {
        return "[Article]author:" + author;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAtFormatted() {
        return LocalDateTimeFormatter.format(createdAt);
    }
}
